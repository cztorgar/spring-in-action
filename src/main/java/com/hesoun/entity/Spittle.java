package com.hesoun.entity;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Main entity class
 *
 * @author Jakub Hesoun
 */
public class Spittle {
    private final UUID id;
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
        this.id = UUID.randomUUID();
        this.message = message;
        this.time = time;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getId() {
        return id.toString();
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
