package com.capgemini.hotel;

import javafx.util.converter.LocalDateStringConverter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long guestID;
    private long roomID;
    private long bookID;
    private LocalDate startDate;
    private LocalDate stopDate;
    private boolean guestPaid = false;

    protected Booking() {}

    public Booking(int guestID, int roomID, LocalDate startDate, LocalDate stopDate, boolean guestPaid) {
        this.guestID = guestID;
        this.roomID = roomID;
        this.startDate = startDate;
        this.stopDate = stopDate;
        this.guestPaid = guestPaid;
    }

    public void setGuestID(int guestID) {
        guestID = guestID;
    }

    public void setRoomID(int roomID) {
        roomID = roomID;
    }

    public void setBookID(int bookID) {
        bookID = bookID;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public void setStopDate(LocalDate stopDate) {
        this.stopDate = stopDate;
    }

    public void setGuestPaid(boolean guestPaid) {
        this.guestPaid = guestPaid;
    }

    public long getGuestID() {
        return guestID;
    }

    public long getRoomID() {
        return roomID;
    }

    public long getBookID() {
        return bookID;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getStopDate() {
        return stopDate;
    }

    public boolean isGuestPaid() {
        return guestPaid;
    }
    @Override
    public String toString()
    {
        return "Guest number: " + guestID + " - Room number: " + roomID + " - Booking number" + bookID +
                " - From: " + startDate + " - To: " + stopDate;
    }

}

