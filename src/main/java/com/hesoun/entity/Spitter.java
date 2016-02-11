package com.hesoun.entity;


import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.UUID;

/**
 * Model representing Spittr user, which can post {@link Spittle}
 *
 * @author Jakub Hesoun
 */
public class Spitter {
    @NotNull
    private UUID id;
    @NotNull
    @Size(min = 5, max = 30)
    private String username;
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    @NotNull
    @Size(min = 5, max = 30)
    private String password;

    //needed for Spring MVC along with getter, otherwise form fields are not mapped to the model
    public Spitter() {
        this(null, null, null, null);
    }

    public Spitter(String username, String firstName, String lastName, String password) {
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
