package com.example.lo.viewModels;

public class TombolaModel {



    String tombolaemail;

    public String getTombolaemail() {
        return tombolaemail;
    }

    public void setTombolaemail(String tombolaemail) {
        this.tombolaemail = tombolaemail;
    }

    public String getTombolaticktNumber() {
        return tombolaticktNumber;
    }

    public void setTombolaticktNumber(String tombolaticktNumber) {
        this.tombolaticktNumber = tombolaticktNumber;
    }

    public String getTombolauniquqNumber() {
        return tombolauniquqNumber;
    }

    public void setTombolauniquqNumber(String tombolauniquqNumber) {
        this.tombolauniquqNumber = tombolauniquqNumber;
    }

    public String getTombolaetaNumber() {
        return tombolaetaNumber;
    }

    public void setTombolaetaNumber(String tombolaetaNumber) {
        this.tombolaetaNumber = tombolaetaNumber;
    }

    public TombolaModel(String tombolaemail, String tombolaticktNumber, String tombolauniquqNumber, String tombolaetaNumber) {
        this.tombolaemail = tombolaemail;
        this.tombolaticktNumber = tombolaticktNumber;
        this.tombolauniquqNumber = tombolauniquqNumber;
        this.tombolaetaNumber = tombolaetaNumber;
    }

    public TombolaModel() {
    }

    String tombolaticktNumber;
    String tombolauniquqNumber;
    String tombolaetaNumber;

}
