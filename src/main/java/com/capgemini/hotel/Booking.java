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

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int bookID;
    private boolean guestPaid = false;

    @ManyToOne
    private Room room;
    private Guest guest;
    private LocalDate startDate;
    private LocalDate stopDate;

    public Booking(boolean guestPaid, int bookID, Room room, Guest guest, LocalDate startDate, LocalDate stopDate) {
        this.guestPaid = guestPaid;
        this.bookID = bookID;
        this.room = room;
        this.guest = guest;
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
    }}




