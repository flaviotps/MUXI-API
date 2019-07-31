package com.flaviotps.muxi.domain.model;


import javax.persistence.Entity;

@Entity
public class Step1DTO {


    private String bcpfSessionId;
    private String bcpfUrl;
    private String cpf;
    private String branch;
    private String account;
    private String digit;
    private String holder;

    public Step1DTO() {
    }

    public String getBcpfSessionId() {
        return bcpfSessionId;
    }

    public void setBcpfSessionId(String bcpfSessionId) {
        this.bcpfSessionId = bcpfSessionId;
    }

    public String getBcpfUrl() {
        return bcpfUrl;
    }

    public void setBcpfUrl(String bcpfUrl) {
        this.bcpfUrl = bcpfUrl;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getDigit() {
        return digit;
    }

    public void setDigit(String digit) {
        this.digit = digit;
    }

    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }
}
