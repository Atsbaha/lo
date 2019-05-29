package com.example.lo.viewModels;

public class InstantModel {
    String emaill;
    String ticketNumberr;
    String birrAmount;

    public String getEmaill() {
        return emaill;
    }

    public void setEmaill(String emaill) {
        this.emaill = emaill;
    }

    public String getTicketNumberr() {
        return ticketNumberr;
    }

    public void setTicketNumberr(String ticketNumberr) {
        this.ticketNumberr = ticketNumberr;
    }

    public String getBirrAmount() {
        return birrAmount;
    }

    public void setBirrAmount(String birrAmount) {
        this.birrAmount = birrAmount;
    }





    public InstantModel(String emaill, String ticketNumberr, String birrAmount) {
        this.emaill = emaill;
        this.ticketNumberr = ticketNumberr;
        this.birrAmount = birrAmount;
    }

    public InstantModel() {
    }




}
