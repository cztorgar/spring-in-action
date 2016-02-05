package com.hesoun.entity;

import java.util.UUID;

/**
 * Model representing Spittr user, which can post {@link Spittle}
 *
 * @author Jakub Hesoun
 */
public class Spitter {
    private UUID id;
    private String username;
    private String firstName;
    private String lastName;
    private String password;

    //needed for Spring MVC
    public Spitter(){
        this(null,null,null,null);
    }

    public Spitter(String username, String firstName, String lastName,String password) {
        this.id = UUID.randomUUID();
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
    }

    public String getId() {
        return id.toString();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
