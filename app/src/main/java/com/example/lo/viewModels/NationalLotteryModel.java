package com.example.lo.viewModels;

public class NationalLotteryModel {


    String emaillAdress;
    String natinalticketNumberr;
    String frequency;
    String birrAmount;

    public NationalLotteryModel() {
    }

    public NationalLotteryModel(String emaillAdress, String natinalticketNumberr, String frequency, String birrAmount) {
        this.emaillAdress = emaillAdress;
        this.natinalticketNumberr = natinalticketNumberr;
        this.frequency = frequency;
        this.birrAmount = birrAmount;
    }

    public String getEmaillAdress() {
        return emaillAdress;
    }

    public void setEmaillAdress(String emaillAdress) {
        this.emaillAdress = emaillAdress;
    }

    public String getNatinalticketNumberr() {
        return natinalticketNumberr;
    }

    public void setNatinalticketNumberr(String natinalticketNumberr) {
        this.natinalticketNumberr = natinalticketNumberr;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public String getBirrAmount() {
        return birrAmount;
    }

    public void setBirrAmount(String birrAmount) {
        this.birrAmount = birrAmount;
    }




}

