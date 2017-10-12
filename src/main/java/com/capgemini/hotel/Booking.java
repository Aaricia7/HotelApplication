package com.capgemini.hotel;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDate;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Entity
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long bookID;


    private long guestID;

    private long roomID;


    private int peopleBooking;
    private EBookingCheckIn checkIn;


    @ManyToOne
    private Room room;

    @ManyToOne
    private Guest guest;
    @NotNull(message="Geef een begin datum op.")
    private LocalDate startDate;
    @NotNull(message="Geef een eind datum op.")
    private LocalDate stopDate;

    private boolean guestPaid = false;

    protected Booking() {}

    public EBookingCheckIn getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(EBookingCheckIn checkIn) {
        this.checkIn = checkIn;
    }

    public long getGuestID() {
        return guestID;
    }

    public void setGuestID(long guestID) {
        this.guestID = guestID;
    }

    public long getRoomID() {
        return roomID;
    }

    public void setRoomID(long roomID) {
        this.roomID = roomID;
    }

    public long getBookID() {
        return bookID;
    }

    public void setBookID(long bookID) {
        this.bookID = bookID;
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

    public boolean isGuestPaid() {
        return guestPaid;
    }

    public void setGuestPaid(boolean guestPaid) {
        this.guestPaid = guestPaid;
    }

    public int getPeopleBooking() {
        return peopleBooking;
    }

    public void setPeopleBooking(int peopleBooking) {
        this.peopleBooking = peopleBooking;
    }
}



