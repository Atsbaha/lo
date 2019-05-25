package com.example.lo.viewModels;

public class EnkutatashModel {

    String useremail;
    String userticktNumber;
    String ticketUniquqNumber;

    public EnkutatashModel() {

    }

    public EnkutatashModel(String useremail, String userticktNumber, String ticketUniquqNumber) {
        this.useremail = useremail;
        this.userticktNumber = userticktNumber;
        this.ticketUniquqNumber = ticketUniquqNumber;
    }

    public String getUseremail() {
        return useremail;
    }

    public void setUseremail(String useremail) {
        this.useremail = useremail;
    }

    public String getUserticktNumber() {
        return userticktNumber;
    }

    public void setUserticktNumber(String userticktNumber) {
        this.userticktNumber = userticktNumber;
    }

    public String getTicketUniquqNumber() {
        return ticketUniquqNumber;
    }

    public void setTicketUniquqNumber(String ticketUniquqNumber) {
        this.ticketUniquqNumber = ticketUniquqNumber;
    }






}
