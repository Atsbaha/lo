package com.example.lo.viewModels;

public class Lyu1Model {


    public String getLyu1email() {
        return lyu1email;
    }

    public void setLyu1email(String lyu1email) {
        this.lyu1email = lyu1email;
    }

    public String getLyu1ticktNumber() {
        return lyu1ticktNumber;
    }

    public void setLyu1ticktNumber(String lyu1ticktNumber) {
        this.lyu1ticktNumber = lyu1ticktNumber;
    }

    public String getLyu1uniquqNumber() {
        return lyu1uniquqNumber;
    }

    public void setLyu1uniquqNumber(String lyu1uniquqNumber) {
        this.lyu1uniquqNumber = lyu1uniquqNumber;
    }

    public String getLyu1etaNumber() {
        return lyu1etaNumber;
    }

    public void setLyu1etaNumber(String lyu1etaNumber) {
        this.lyu1etaNumber = lyu1etaNumber;
    }

    public Lyu1Model(String lyu1email, String lyu1ticktNumber, String lyu1uniquqNumber, String lyu1etaNumber) {
        this.lyu1email = lyu1email;
        this.lyu1ticktNumber = lyu1ticktNumber;
        this.lyu1uniquqNumber = lyu1uniquqNumber;
        this.lyu1etaNumber = lyu1etaNumber;
    }

    String lyu1email;
    String lyu1ticktNumber;

    public Lyu1Model() {
    }

    String lyu1uniquqNumber;
    String lyu1etaNumber;


}
