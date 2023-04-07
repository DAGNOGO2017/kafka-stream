package com.example.velo.Controller;

import java.security.KeyPair;
import java.time.Duration;
import java.util.Properties;

import com.example.velo.model.Event;
import com.example.velo.model.Velo;
import com.example.velo.model.VeloEventJoin;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.*;
import org.apache.kafka.streams.kstream.*;

import org.apache.log4j.Logger;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.kafka.support.serializer.JsonSerde;
import org.springframework.kafka.support.serializer.JsonSerializer;



public class VeloController {
    private static Logger logger = Logger.getLogger(VeloController.class);

    public class EventSerde extends Serdes.WrapperSerde<Event> {
        public EventSerde() {
            super(new JsonSerializer<>(), new JsonDeserializer<>(Event.class));
        }
    }
    private static KafkaStreams streamsInnerJoin;
    //Kafka stream exemple with ktable and kstream from json files
    public static void main(String[] args) throws Exception {
        Properties props = new Properties();
        props.put(StreamsConfig.APPLICATION_ID_CONFIG, "velo-demo-stream-application");
        props.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass());
        props.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, eventSerde2.class.getName() );
        //props.put(StreamsConfig)
        //kafka-streams.auto.offset.reset=earliest
        //kafka-streams.metrics.recording.level=DEBUG


        StreamsBuilder builder = new StreamsBuilder();

        JsonSerializer<Velo> veloJsonSerializer = new JsonSerializer<>();
        JsonDeserializer<Velo> veloJsonDeserializer = new JsonDeserializer<>(Velo.class);
        Serde<Velo> veloSerde = Serdes.serdeFrom(veloJsonSerializer, veloJsonDeserializer);


        JsonSerializer<Event> eventJsonSerializer = new JsonSerializer<>();
        JsonDeserializer<Event> eventJsonDeserializer = new JsonDeserializer<>(Event.class);
        Serde<Event> eventSerde = Serdes.serdeFrom(eventJsonSerializer, eventJsonDeserializer);
        //builder.stream(Serdes.String(), trxSerde, TOPIC_IN);
        //GlobalKTable<String, Velo> veloKStream = builder.globalTable("velo", Consumed.with(Serdes.String(), veloSerde));
        KStream<String, Event> eventKStream = builder.stream("event", Consumed.with(Serdes.String(), eventSerde));
        KStream<String, Velo> veloKStream = builder.stream("velo", Consumed.with(Serdes.String(), veloSerde));

        //veloKStream.print(Printed.toSysOut());

        KStream<String, String> join = eventKStream.join(veloKStream, (event, velo) -> {
            final VeloEventJoin veloEventJoin = new VeloEventJoin();
            veloEventJoin.setClient_id(event.getClient_id());
            System.out.println("Test Logger" + veloEventJoin.getClient_id());
            return veloEventJoin.toString();
        }, JoinWindows.of(Duration.ofSeconds(2)), StreamJoined.with(Serdes.String(), eventSerde, veloSerde));


        final KStream<String, VeloEventJoin> stringVeloEventJoinKStream = eventKStream.join(veloKStream,
                (eventId, velo) -> velo.getStationcode(),
                (test) -> new VeloEventJoin(test));


        join.foreach((k, v) -> {
            System.out.println("event stream key :"+k + " value : "+ v );
            //logger.info("event stream -> key [{}], value [{}]".formatted(k,v));
        });

        //show K

        //eventKStream.map((key, value) -> KeyValue.pair(value.getStationcode(), value)).join(veloKStream,
         //       (stationcode, eventid) -> stationcode, (velo., event) -> event).print(Printed.toSysOut());




        KafkaStreams streams = new KafkaStreams(builder.build(), props);
        streams.start();

        //veloKStream.print(Printed.toSysOut());
        /*KTable<String, Velo> veloTable = veloKStream.selectKey((k,v) -> v.getStationcode())
                .groupByKey().reduce((velo, v1) -> {
                    velo.setCapacity(velo.getCapacity() -1);
            return velo;
                });

        KTable<String, Event> eventKTable = eventKStream
                .selectKey((key, customer) -> customer.getStationcode())
                .toTable();*/


   /*     KTable<String, String> VeloEventKtable = veloTable
                .join(eventKTable,
                        Joined.with(
                                Serdes.String(),
                                new JsonSerde<>(Velo.class),
                                new JsonSerde<>(Event.class)
                        ),
                        Materialized.as("customer-orders"));*/

    }
    static public final class veloSerde2 extends Serdes.WrapperSerde<Velo> {
        public veloSerde2() {
            super(new JsonSerializer<Velo>(), new JsonDeserializer<Velo>(Velo.class));
        }
    }

    static public final class eventSerde2 extends Serdes.WrapperSerde<Event> {
        public eventSerde2() {
            super(new JsonSerializer<Event>(), new JsonDeserializer<Event>(Event.class));
        }
    }
}


