package com.flaviotps.muxi.model.domain;


import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class TerminalModel {

    @Id
    @GeneratedValue
    private long id;

    @JsonProperty("logic")
    private int logic;
    @JsonProperty("serial")
    private String serial;
    @JsonProperty("model")
    private String model;
    @JsonProperty("sam")
    private int sam;
    @JsonProperty("ptid")
    private String ptid;
    @JsonProperty("plat")
    private int plat;
    @JsonProperty("version")
    private String version;
    @JsonProperty("mxr")
    private int mxr;
    @JsonProperty("mxf")
    private int mxf;
    @JsonProperty("VERFM")
    private String VERFM;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getLogic() {
        return logic;
    }

    public void setLogic(int logic) {
        this.logic = logic;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getSam() {
        return sam;
    }

    public void setSam(int sam) {
        this.sam = sam;
    }

    public String getPtid() {
        return ptid;
    }

    public void setPtid(String ptid) {
        this.ptid = ptid;
    }

    public int getPlat() {
        return plat;
    }

    public void setPlat(int plat) {
        this.plat = plat;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public int getMxr() {
        return mxr;
    }

    public void setMxr(int mxr) {
        this.mxr = mxr;
    }

    public String getVERFM() {
        return VERFM;
    }

    public void setVERFM(String VERFM) {
        this.VERFM = VERFM;
    }
}
