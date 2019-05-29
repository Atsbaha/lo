package com.example.lo.viewModels;


public class BingoModel {
    String emaill;
//    String ticketNumberr;
    String birrAmount;
    String uniqueNumber;

    public String getUniqueNumber() {
        return uniqueNumber;
    }

    public void setUniqueNumber(String uniqueNumber) {
        this.uniqueNumber = uniqueNumber;
    }



    public String getEmaill() {
        return emaill;
    }

    public void setEmaill(String emaill) {
        this.emaill = emaill;
    }

//    public String getTicketNumberr() {
//        return ticketNumberr;
//    }

//    public void setTicketNumberr(String ticketNumberr) {
//        this.ticketNumberr = ticketNumberr;
//    }

    public String getBirrAmount() {
        return birrAmount;
    }

    public void setBirrAmount(String birrAmount) {
        this.birrAmount = birrAmount;
    }





    public BingoModel(String emaill, String birrAmount,String uniqueNumber) {
        this.emaill = emaill;
//        this.ticketNumberr = ticketNumberr;
        this.birrAmount = birrAmount;
        this.uniqueNumber=uniqueNumber;
    }

    public BingoModel() {
    }


}
