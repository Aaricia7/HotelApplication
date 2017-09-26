package com.capgemini.hotel;

public class Booking {

    private int GuestID;
    private int RoomID;
    private int BookID;
    private String startDate;
    private String stopDate;
    private boolean guestPaid = false;

    public Booking(int guestID, int roomID, int bookID, String startDate, String stopDate, boolean guestPaid) {
        GuestID = guestID;
        RoomID = roomID;
        BookID = bookID;
        this.startDate = startDate;
        this.stopDate = stopDate;
        this.guestPaid = guestPaid;
    }

    public void setGuestID(int guestID) {
        GuestID = guestID;
    }

    public void setRoomID(int roomID) {
        RoomID = roomID;
    }

    public void setBookID(int bookID) {
        BookID = bookID;
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
        return GuestID;
    }

    public int getRoomID() {
        return RoomID;
    }

    public int getBookID() {
        return BookID;
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

