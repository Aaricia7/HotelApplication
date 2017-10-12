package com.capgemini.hotel;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Guest {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long guestID;
    private String guestFirstName;
    private String guestLastName;
    private String guestAdress;
    private String guestZipcode;
    private String guestCity;
    private String guestCountry;
    private String guestPhonenumber;
    private String guestEmailAdress;

    protected Guest() {}

    public void setGuestFirstName(String guestFirstName) {
        this.guestFirstName = guestFirstName;
    }

    public void setGuestLastName(String guestLastName) {
        this.guestLastName = guestLastName;
    }

    public void setGuestAdress(String guestAdress) {
        this.guestAdress = guestAdress;
    }

    public void setGuestZipcode(String guestZipcode) {
        this.guestZipcode = guestZipcode;
    }

    public void setGuestCity(String guestCity) {
        this.guestCity = guestCity;
    }

    public void setGuestCountry(String guestCountry) {
        this.guestCountry = guestCountry;
    }

    public void setGuestPhonenumber(String guestPhonenumber) {
        this.guestPhonenumber = guestPhonenumber;
    }

    public void setGuestEmailAdress(String guestEmailAdress) {
        this.guestEmailAdress = guestEmailAdress;
    }

    public String getGuestFirstName() {
        return guestFirstName;
    }

    public String getGuestLastName() {
        return guestLastName;
    }

    public String getGuestAdress() {
        return guestAdress;
    }

    public String getGuestZipcode() {
        return guestZipcode;
    }

    public String getGuestCity() {
        return guestCity;
    }

    public String getGuestCountry() {
        return guestCountry;
    }

    public String getGuestPhonenumber() {
        return guestPhonenumber;
    }

    public String getGuestEmailAdress() {
        return guestEmailAdress;
    }

    public long getGuestID() {
        return guestID;
    }

    public void setGuestID(long guestID) {
        this.guestID = guestID;
    }




}