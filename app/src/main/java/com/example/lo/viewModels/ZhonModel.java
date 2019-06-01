package com.example.lo.viewModels;

public class ZhonModel {


    String email;
    String ticktNumber;
    String uniquqNumber;
    String etaNumber;

    public String getEtaNumber() {
        return etaNumber;
    }

    public void setEtaNumber(String etaNumber) {
        this.etaNumber = etaNumber;
    }

    public ZhonModel() {
    }

    public ZhonModel(String email, String ticktNumber,String uniquqNumber,String etaNumber) {
        this.email = email;
        this.ticktNumber = ticktNumber;
        this.uniquqNumber=uniquqNumber;
        this.etaNumber=etaNumber;
    }



    public String getUniquqNumber() {
        return uniquqNumber;
    }

    public void setUniquqNumber(String uniquqNumber) {
        this.uniquqNumber = uniquqNumber;
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
