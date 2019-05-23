package com.example.lo.viewModels;

public class EnkutatashModel {

    String Useremail;
    String UserticktNumber;
    String TicketUniquqNumber;

    public EnkutatashModel() {
    }

    public String getUseremail() {
        return Useremail;
    }

    public void setUseremail(String useremail) {
        Useremail = useremail;
    }

    public String getUserticktNumber() {
        return UserticktNumber;
    }

    public void setUserticktNumber(String userticktNumber) {
        UserticktNumber = userticktNumber;
    }

    public String getTicketUniquqNumber() {
        return TicketUniquqNumber;
    }

    public void setTicketUniquqNumber(String ticketUniquqNumber) {
        TicketUniquqNumber = ticketUniquqNumber;
    }



    public EnkutatashModel(String useremail, String userticktNumber, String ticketUniquqNumber) {
        Useremail = useremail;
        UserticktNumber = userticktNumber;
        TicketUniquqNumber = ticketUniquqNumber;
    }


}
