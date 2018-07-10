package com.formation.tpIO;

import java.util.Date;

public class User {
    private Long id;
    private String createAt;
    private String firstname;
    private String lastname;
    private String phone;
    private String email;

    public User() {
    }

    public User(Long id, String createAt, String firstname, String lastname, String phone, String email) {
        this.id = id;
        this.createAt = createAt;
        this.firstname = firstname;
        this.lastname = lastname;
        this.phone = phone;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCreateAt() {
        return createAt;
    }

    public void setCreateAt(String createAt) {
        this.createAt = createAt;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return firstname + " " + lastname +
                " s’est inscrit le " + createAt +
                ". On peut le contacter au " + phone +
                " ou avec l’adresse mail : " + email + "\n";
    }
}
