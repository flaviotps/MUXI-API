package com.flaviotps.muxi.domain.model;


import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class TerminalModel {

    @Id
    @JsonProperty("logic")
    @Column(updatable = false)
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
    private String verfm;




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

    public int getMxf() {
        return mxf;
    }

    public void setMxf(int mxf) {
        this.mxf = mxf;
    }

    public String getVerfm() {
        return verfm;
    }

    public void setVerfm(String verfm) {
        this.verfm = verfm;
    }
}
