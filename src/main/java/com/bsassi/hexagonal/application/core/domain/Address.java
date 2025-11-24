package com.bsassi.hexagonal.application.core.domain;


public class Address {

    public Address(){}

    public Address(String street, String state, String city) {
        this.street = street;
        this.state = state;
        this.city = city;
    }

    private String city;
    private String state;
    private String street;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }




}
