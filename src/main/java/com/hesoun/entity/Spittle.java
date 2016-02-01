package com.hesoun.entity;

import java.time.LocalDateTime;

/**
 * Main entity class
 */
public class Spittle {
    private final Long id;
    private final String message;
    private final LocalDateTime time;
    private Double latitude;
    private Double longitude;

    public Spittle(String message){
        this(message,LocalDateTime.now());
    }

    public Spittle(String message, LocalDateTime time) {
        this(message, time, 0d, 0d);
    }

    public Spittle(String message, LocalDateTime time, Double latitude, Double longitude) {
        this.id = null;
        this.message = message;
        this.time = time;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Long getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }
}
