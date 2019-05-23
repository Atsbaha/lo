package com.example.lo.viewModels;

public class GenaModel {
    String email;

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
        return UniquqNumber;
    }

    public void setUniquqNumber(String uniquqNumber) {
        UniquqNumber = uniquqNumber;
    }

    String ticktNumber;
    String UniquqNumber;

    public GenaModel() {
    }


    public GenaModel(String email, String ticktNumber, String uniquqNumber) {
        this.email = email;
        this.ticktNumber = ticktNumber;
        UniquqNumber = uniquqNumber;
    }




}
