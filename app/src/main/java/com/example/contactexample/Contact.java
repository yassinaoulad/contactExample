package com.example.contactexample;

import java.io.Serializable;

public class Contact implements Serializable {
    String name;
    String gender;
    String number;
    int picture;

    public int getPicture() {
        return picture;
    }

    public void setPicture(int picture) {
        this.picture = picture;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public String getNumber() {
        return number;
    }

    public Contact() {

    }

    public Contact(String name, String gender, String number, int picture) {
        this.name = name;
        this.gender = gender;
        this.number = number;
        this.picture = picture;
    }
}
