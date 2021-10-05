package com.myownapp.masteringjwt.user;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue
    @Column(name="user_id")
    private int id;

    @Size(min = 5,max = 20,message = "The length of 'First Name' must be between 5 and 20 ")
    @Column(name="firstname", length = 20, nullable = false)
    private String firstname;

    @Size(min = 5,max = 20,message = "The length of 'Last Name' must be between 5 and 20 ")
    @Column(name="lastname", length = 20, nullable = false)
    private String lastname;

    public User() {
    }

    public User(int id, String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}
