package com.example.velo.model;

import java.sql.Date;
import java.util.Objects;

public class Velo {
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

    public Velo() {
    }

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

    @Override
    public String toString() {
        return "Velo{" +
                "stationcode='" + stationcode + '\'' +
                ", name='" + name + '\'' +
                ", is_installed='" + is_installed + '\'' +
                ", capacity=" + capacity +
                ", numdocksavailable=" + numdocksavailable +
                ", numbikeavailable=" + numbikeavailable +
                ", mechanical=" + mechanical +
                ", ebike=" + ebike +
                ", is_renting='" + is_renting + '\'' +
                ", is_returning='" + is_returning + '\'' +
                ", duedate=" + duedate +
                ", nom_arrondissement='" + nom_arrondissement + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Velo velo)) return false;
        return Objects.equals(getStationcode(), velo.getStationcode()) && Objects.equals(getName(), velo.getName()) && Objects.equals(getIs_installed(), velo.getIs_installed()) && Objects.equals(getCapacity(), velo.getCapacity()) && Objects.equals(getNumdocksavailable(), velo.getNumdocksavailable()) && Objects.equals(getNumbikeavailable(), velo.getNumbikeavailable()) && Objects.equals(getMechanical(), velo.getMechanical()) && Objects.equals(getEbike(), velo.getEbike()) && Objects.equals(getIs_renting(), velo.getIs_renting()) && Objects.equals(getIs_returning(), velo.getIs_returning()) && Objects.equals(getDuedate(), velo.getDuedate()) && Objects.equals(getNom_arrondissement(), velo.getNom_arrondissement());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getStationcode(), getName(), getIs_installed(), getCapacity(), getNumdocksavailable(), getNumbikeavailable(), getMechanical(), getEbike(), getIs_renting(), getIs_returning(), getDuedate(), getNom_arrondissement());
    }
}
