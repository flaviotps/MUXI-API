package com.flaviotps.muxi.domain.model;


import javax.persistence.Entity;

@Entity
public class Step1Form {

    private String deviceId;
    private String plataform;
    private String campaign;

    public Step1Form() {
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getPlataform() {
        return plataform;
    }

    public void setPlataform(String plataform) {
        this.plataform = plataform;
    }

    public String getCampaign() {
        return campaign;
    }

    public void setCampaign(String campaign) {
        this.campaign = campaign;
    }
}
