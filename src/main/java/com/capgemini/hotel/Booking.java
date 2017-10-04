package com.capgemini.hotel;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Booking {

    private int guestID;
    private int roomID;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int bookID;
    private String startDate;
    private String stopDate;
    private boolean guestPaid = false;



    public void setGuestID(int guestID) {
        guestID = guestID;
    }

    public void setRoomID(int roomID) {
        roomID = roomID;
    }

    public void setBookID(int bookID) {
        bookID = bookID;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public void setStopDate(String stopDate) {
        this.stopDate = stopDate;
    }

    public void setGuestPaid(boolean guestPaid) {
        this.guestPaid = guestPaid;
    }

    public int getGuestID() {
        return guestID;
    }

    public int getRoomID() {
        return roomID;
    }

    public int getBookID() {
        return bookID;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getStopDate() {
        return stopDate;
    }

    public boolean isGuestPaid() {
        return guestPaid;
    }

}

