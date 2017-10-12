package com.capgemini.hotel;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.Valid;
import javax.validation.constraints.Pattern;

@Entity
public class Guest {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long guestID;
    @NotEmpty
    @Length(max = 25, min = 1, message = "THUGLIFE")
    private String guestFirstName;
    @Length(max = 25, min = 1, message = "THUGLIFE")
    private String guestLastName;
    @NotEmpty
    private String guestAdress;
    @NotEmpty
    private String guestZipcode;
    @NotEmpty
    private String guestCity;
    @NotEmpty
    private String guestCountry;
    @Valid
    @Pattern(regexp="\\d+", message = "Bitch vul in")
    private String guestPhonenumber;
    @Valid
    @Email (message = "THUGLIFE2")
    @Length(min = 1, message = "THUGLIFE")
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