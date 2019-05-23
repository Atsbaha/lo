package com.example.lo.viewModels;

public class ZhonModel {


    String email;
    String ticktNumber;
    String UniquqNumber;

    public String getUniquqNumber() {
        return UniquqNumber;
    }

    public void setUniquqNumber(String uniquqNumber) {
        UniquqNumber = uniquqNumber;
    }


    public ZhonModel(String email, String ticktNumber,String UniquqNumber) {
        this.email = email;
        this.ticktNumber = ticktNumber;
        this.UniquqNumber=UniquqNumber;
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




}
