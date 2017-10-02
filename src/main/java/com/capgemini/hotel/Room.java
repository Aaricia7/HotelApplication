package com.capgemini.hotel;

public class Room {

    private ERoomSize roomSize;
    private ERoomType roomType;
    private int roomID;
    private String dateReady;
    private boolean roomAvailable;


    public Room(int roomID, ERoomSize roomSize, ERoomType roomType, boolean roomAvailable, String dateReady) {
        this.roomSize = roomSize;
        this.roomType = roomType;
        this.roomID = roomID;
        this.dateReady = dateReady;
        this.roomAvailable = roomAvailable;
    }

    public void setRoomAvailable(boolean roomAvailable) {
        this.roomAvailable = roomAvailable;
    }

    public void setRoomSize(ERoomSize roomSize) {
        this.roomSize = roomSize;
    }

    public void setRoomType(ERoomType roomType) {
        this.roomType = roomType;
    }

    public void setRoomID(int roomID) {
        this.roomID = roomID;
    }

    public void setDateReady(String dateReady) {
        this.dateReady = dateReady;
    }

    public ERoomSize getRoomSize() {
        return roomSize;
    }

    public ERoomType getRoomType() {
        return roomType;
    }

    public int getRoomID() {
        return roomID;
    }

    public String getDateReady() {
        return dateReady;
    }

    public boolean isRoomAvailable() {
        return roomAvailable;
    }

    @Override
    public String toString() {
        return "Room " + roomID + " - Roomtype: " + roomType + " - Roomsize: " + roomSize + " - Available : " +
                roomAvailable + " - Date ready: " + dateReady + "\n";

    }
}
