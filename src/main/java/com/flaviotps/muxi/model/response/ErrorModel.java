package com.flaviotps.muxi.model.response;

import org.json.JSONObject;

import java.io.Serializable;
import java.security.Timestamp;
import java.text.SimpleDateFormat;
import java.time.Instant;

public class ErrorModel extends JSONObject {


    public ErrorModel(String msg, String stacktrace) {
        Instant instant = Instant.now();
        long timeStampMillis = instant.toEpochMilli();
        put("message", msg);
        put("stacktrace", stacktrace);
        put("timestamp", timeStampMillis);
    }

    public ErrorModel(String msg) {
        Instant instant = Instant.now();
        long timeStampMillis = instant.toEpochMilli();
        put("message", msg);
        put("timestamp", timeStampMillis);
    }

}
