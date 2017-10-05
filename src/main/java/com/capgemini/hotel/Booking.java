package com.capgemini.hotel;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

import javafx.util.converter.LocalDateStringConverter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Booking {

    private int guestID;
    private int roomID;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int bookID;
    private boolean guestPaid = false;

    @ManyToOne
    private Room room;
    private Guest guest;
    private LocalDate startDate;
    private LocalDate stopDate;

    public Booking(int guestID, int roomID, int bookID, LocalDate startDate, LocalDate stopDate, boolean guestPaid) {
        this.guestID = guestID;
        this.roomID = roomID;
        this.bookID = bookID;
        this.startDate = startDate;
        this.stopDate = stopDate;
        this.guestPaid = guestPaid;
    }

    public int getBookID() {
        return bookID;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    public boolean isGuestPaid() {
        return guestPaid;
    }

    public void setGuestPaid(boolean guestPaid) {
        this.guestPaid = guestPaid;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Guest getGuest() {
        return guest;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getStopDate() {
        return stopDate;
    }

    public void setStopDate(LocalDate stopDate) {
        this.stopDate = stopDate;
    }


    @Override
    public String toString() {


        return "Guest number: " + guestID + " - Room number: " + roomID + " - Booking number" + bookID +
                " - From: " + startDate + " - To: " + stopDate;
    }
}



