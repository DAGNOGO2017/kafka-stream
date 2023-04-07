package com.example.velo.model;

import java.sql.Date;
import java.util.Objects;

public class VeloEventJoin {
    private String stationcode;
    private String name;
    private String is_installed;
    private Integer capacity;
    private Integer numdocksavailable;
    private Integer numbikeavailable;
    private Integer mechanical;

    private Integer ebike;
    private String is_renting;
    private String is_returning;
    private Date duedate;
    private String nom_arrondissement;
    private String client_id;
    private Boolean retrait_depot;
    private String timestamp;
    private String velo_type;
    private Velo velo;


    public String getStationcode() {
        return stationcode;
    }

    public void setStationcode(String stationcode) {
        this.stationcode = stationcode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIs_installed() {
        return is_installed;
    }

    public void setIs_installed(String is_installed) {
        this.is_installed = is_installed;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Integer getNumdocksavailable() {
        return numdocksavailable;
    }

    public void setNumdocksavailable(Integer numdocksavailable) {
        this.numdocksavailable = numdocksavailable;
    }

    public Integer getNumbikeavailable() {
        return numbikeavailable;
    }

    public void setNumbikeavailable(Integer numbikeavailable) {
        this.numbikeavailable = numbikeavailable;
    }

    public Integer getMechanical() {
        return mechanical;
    }

    public void setMechanical(Integer mechanical) {
        this.mechanical = mechanical;
    }

    public Integer getEbike() {
        return ebike;
    }

    public void setEbike(Integer ebike) {
        this.ebike = ebike;
    }

    public String getIs_renting() {
        return is_renting;
    }

    public void setIs_renting(String is_renting) {
        this.is_renting = is_renting;
    }

    public String getIs_returning() {
        return is_returning;
    }

    public void setIs_returning(String is_returning) {
        this.is_returning = is_returning;
    }

    public Date getDuedate() {
        return duedate;
    }

    public void setDuedate(Date duedate) {
        this.duedate = duedate;
    }

    public String getNom_arrondissement() {
        return nom_arrondissement;
    }

    public void setNom_arrondissement(String nom_arrondissement) {
        this.nom_arrondissement = nom_arrondissement;
    }

    public String getClient_id() {
        return client_id;
    }

    public void setClient_id(String client_id) {
        this.client_id = client_id;
    }

    public Boolean getRetrait_depot() {
        return retrait_depot;
    }

    public void setRetrait_depot(Boolean retrait_depot) {
        this.retrait_depot = retrait_depot;
    }

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

    public Velo getVelo() {
        return velo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof VeloEventJoin that)) return false;
        return Objects.equals(getStationcode(), that.getStationcode()) && Objects.equals(getName(), that.getName()) && Objects.equals(getIs_installed(), that.getIs_installed()) && Objects.equals(getCapacity(), that.getCapacity()) && Objects.equals(getNumdocksavailable(), that.getNumdocksavailable()) && Objects.equals(getNumbikeavailable(), that.getNumbikeavailable()) && Objects.equals(getMechanical(), that.getMechanical()) && Objects.equals(getEbike(), that.getEbike()) && Objects.equals(getIs_renting(), that.getIs_renting()) && Objects.equals(getIs_returning(), that.getIs_returning()) && Objects.equals(getDuedate(), that.getDuedate()) && Objects.equals(getNom_arrondissement(), that.getNom_arrondissement()) && Objects.equals(getClient_id(), that.getClient_id()) && Objects.equals(getRetrait_depot(), that.getRetrait_depot()) && Objects.equals(getTimestamp(), that.getTimestamp()) && Objects.equals(getVelo_type(), that.getVelo_type()) && Objects.equals(getVelo(), that.getVelo());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getStationcode(), getName(), getIs_installed(), getCapacity(), getNumdocksavailable(), getNumbikeavailable(), getMechanical(), getEbike(), getIs_renting(), getIs_returning(), getDuedate(), getNom_arrondissement(), getClient_id(), getRetrait_depot(), getTimestamp(), getVelo_type(), getVelo());
    }

    public void setVelo(Velo velo) {
        this.velo = velo;
    }

    public VeloEventJoin(String stationcode) {
        this.stationcode = stationcode;
    }
}
