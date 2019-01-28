package com.flaviotps.muxi.domain.response;

import org.json.JSONObject;

import java.time.Instant;

public class ErrorResponse extends JSONObject {


    public ErrorResponse(String msg, String stacktrace) {
        Instant instant = Instant.now();
        long timeStampMillis = instant.toEpochMilli();
        put("message", msg);
        put("stacktrace", stacktrace);
        put("timestamp", timeStampMillis);
    }

    public ErrorResponse(String msg) {
        Instant instant = Instant.now();
        long timeStampMillis = instant.toEpochMilli();
        put("message", msg);
        put("timestamp", timeStampMillis);
    }

}
