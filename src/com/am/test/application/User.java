package com.am.test.application;

import java.sql.Timestamp;

public class User {

    private String firstname;
    private String lastname;
    private int age;
    private String email;
    public enum Status {
        ACTIVE, INACTIVE, BLOCKED, NEW
    }
    public Status status;
    private Timestamp timestamp;

    public User(String firstname, String lastname, int age, String email) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
        this.email = email;
        this.timestamp = new Timestamp(System.currentTimeMillis());
        this.status = Status.NEW;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "User{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", timestamp=" + timestamp +
                ", status=" + status.toString() +
                '}';
    }

    public void setStatusNew(){
        this.status = Status.NEW;
    }

    public void setStatusActive(){
        this.status = Status.ACTIVE;
    }

    public void setStatusInactive(){
        this.status = Status.INACTIVE;
    }

    public void setStatusBlocked(){
        this.status = Status.BLOCKED;
    }

}
