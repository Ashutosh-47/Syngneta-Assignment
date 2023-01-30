package com.example.Syngneta.field;


public class Field {
    private String firstName;
    private String lastName;
    private String address1;
    private String city;
    private String state;
    private String code;


    public Field(String firstName, String lastName, String address1, String city, String state, String code) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address1 = address1;
        this.city = city;
        this.state = state;
        this.code = code;
    }


    public String getFirstName() {
        return firstName;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
