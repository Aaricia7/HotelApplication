package com.capgemini.hotel;

public class Room {

    private int roomSize;
    private String roomType;
    private int roomID;
    private String dateReady;
    private boolean roomAvailable;
    // map<day,boolean,availabilty>


    public Room(int roomID, int roomSize, String roomType, boolean roomAvailable, String dateReady) {
        this.roomSize = roomSize;
        this.roomType = roomType;
        this.roomID = roomID;
        this.dateReady = dateReady;
        this.roomAvailable = roomAvailable;
    }

    public void setRoomAvailable(boolean roomAvailable) {
        this.roomAvailable = roomAvailable;
    }

    public void setRoomSize(int roomSize) {
        this.roomSize = roomSize;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public void setRoomID(int roomID) {
        this.roomID = roomID;
    }

    public void setDateReady(String dateReady) {
        this.dateReady = dateReady;
    }

    public int getRoomSize() {
        return roomSize;
    }

    public String getRoomType() {
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
        return "Room " + roomID + " - Roomtype: " + roomType + " - Roomsize: " + roomSize + " - Date ready: " + dateReady + "\n";

    }
}
