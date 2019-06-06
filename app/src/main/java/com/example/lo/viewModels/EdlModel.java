package com.example.lo.viewModels;

public class EdlModel {


    public String getEdlemail() {
        return edlemail;
    }

    public void setEdlemail(String edlemail) {
        this.edlemail = edlemail;
    }

    public String getEdlticktNumber() {
        return edlticktNumber;
    }

    public void setEdlticktNumber(String edlticktNumber) {
        this.edlticktNumber = edlticktNumber;
    }

    public String getEdluniquqNumber() {
        return edluniquqNumber;
    }

    public void setEdluniquqNumber(String edluniquqNumber) {
        this.edluniquqNumber = edluniquqNumber;
    }

    public String getEdletaNumber() {
        return edletaNumber;
    }

    public void setEdletaNumber(String edletaNumber) {
        this.edletaNumber = edletaNumber;
    }

    String edlemail;

    public EdlModel() {
    }

    public EdlModel(String edlemail, String edlticktNumber, String edluniquqNumber, String edletaNumber) {
        this.edlemail = edlemail;
        this.edlticktNumber = edlticktNumber;
        this.edluniquqNumber = edluniquqNumber;
        this.edletaNumber = edletaNumber;
    }

    String edlticktNumber;
    String edluniquqNumber;
    String edletaNumber;




}
