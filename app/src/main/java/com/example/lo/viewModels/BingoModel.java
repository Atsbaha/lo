package com.example.lo.viewModels;


public class BingoModel {
    String emailll;
    String birrAmountt;
    String uniqueNumberr;

    public String getUniqueNumberr() {
        return uniqueNumberr;
    }

    public void setUniqueNumberr(String uniqueNumberr) {
        this.uniqueNumberr = uniqueNumberr;
    }



    public String getEmailll() {
        return emailll;
    }

    public void setEmailll(String emaill) {
        this.emailll = emaill;
    }

//    public String getTicketNumberr() {
//        return ticketNumberr;
//    }

//    public void setTicketNumberr(String ticketNumberr) {
//        this.ticketNumberr = ticketNumberr;
//    }

    public String getBirrAmountt() {
        return birrAmountt;
    }

    public void setBirrAmountt(String birrAmount) {
        this.birrAmountt = birrAmount;
    }





    public BingoModel(String emailll, String birrAmountt,String uniqueNumberr) {
        this.emailll = emailll;
//        this.ticketNumberr = ticketNumberr;
        this.birrAmountt = birrAmountt;
        this.uniqueNumberr=uniqueNumberr;
    }

    public BingoModel() {
    }


}
