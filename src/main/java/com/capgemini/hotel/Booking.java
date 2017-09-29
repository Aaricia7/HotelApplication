package com.capgemini.hotel;

public class Booking {

    private int guestID;
    private int roomID;
    private int bookID;
    private String startDate;
    private String stopDate;
    private boolean guestPaid = false;

    public Booking(int guestID, int roomID, int bookID, String startDate, String stopDate, boolean guestPaid) {
        this.guestID = guestID;
        this.roomID = roomID;
        this.bookID = bookID;
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
    @Override
    public String toString()
    {
        return "Guest number: " + guestID + " - Room number: " + roomID + " - Booking number" + bookID +
                " - From: " + startDate + " - To: " + stopDate;
    }

}

