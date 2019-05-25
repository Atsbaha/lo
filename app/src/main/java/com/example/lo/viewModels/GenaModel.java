package com.example.lo.viewModels;

public class GenaModel {
    String email;
    String ticktNumber;
    String uniquqNumber;

    public GenaModel() {
    }

    public GenaModel(String email, String ticktNumber, String uniquqNumber) {
        this.email = email;
        this.ticktNumber = ticktNumber;
        uniquqNumber = uniquqNumber;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTicktNumber() {
        return ticktNumber;
    }

    public void setTicktNumber(String ticktNumber) {
        this.ticktNumber = ticktNumber;
    }

    public String getUniquqNumber() {
        return uniquqNumber;
    }

    public void setUniquqNumber(String uniquqNumber) {
        this.uniquqNumber = uniquqNumber;
    }









}
