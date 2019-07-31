package com.flaviotps.muxi.domain.model;


import javax.persistence.Entity;

@Entity
public class InitDTO {
    public InitDTO() {
    }

    private String token;


    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
