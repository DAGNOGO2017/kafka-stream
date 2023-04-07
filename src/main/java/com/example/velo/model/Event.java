package com.example.velo.model;

import org.apache.kafka.common.serialization.Serde;

import java.util.Objects;

public class Event {
    private String client_id;

    private String stationcode;
    private Boolean retrait_depot;
    private String timestamp;
    private String velo_type;

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getVelo_type() {
        return velo_type;
    }

    public void setVelo_type(String velo_type) {
        this.velo_type = velo_type;
    }

    public Event() {
    }



    public String getClient_id() {
        return client_id;
    }

    public void setClient_id(String client_id) {
        this.client_id = client_id;
    }

    public String getStationcode() {
        return stationcode;
    }

    public void setStationcode(String stationcode) {
        this.stationcode = stationcode;
    }

    public Boolean getRetrait_depot() {
        return retrait_depot;
    }

    public void setRetrait_depot(Boolean retrait_depot) {
        this.retrait_depot = retrait_depot;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Event event)) return false;
        return Objects.equals(getClient_id(), event.getClient_id()) && Objects.equals(getStationcode(), event.getStationcode()) && Objects.equals(getRetrait_depot(), event.getRetrait_depot()) && Objects.equals(getTimestamp(), event.getTimestamp()) && Objects.equals(getVelo_type(), event.getVelo_type());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getClient_id(), getStationcode(), getRetrait_depot(), getTimestamp(), getVelo_type());
    }
}
