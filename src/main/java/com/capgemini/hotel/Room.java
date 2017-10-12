package com.capgemini.hotel;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long roomID;
    private ERoomSize roomSize;
    private ERoomType roomType;
    private LocalDate dateReady;
    private boolean roomAvailable;
    private String roomNumber;

    protected Room() {}

    public ERoomSize getRoomSize() {
        return roomSize;
    }

    public void setRoomSize(ERoomSize roomSize) {
        this.roomSize = roomSize;
    }

    public ERoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(ERoomType roomType) {
        this.roomType = roomType;
    }

    public long getRoomID() {
        return roomID;
    }

    public void setRoomID(long roomID) {
        this.roomID = roomID;
    }

    public LocalDate getDateReady() {
        return dateReady;
    }

    public void setDateReady(LocalDate dateReady) {
        this.dateReady = dateReady;
    }

    public boolean isRoomAvailable() {
        return roomAvailable;
    }

    public void setRoomAvailable(boolean roomAvailable) {

        this.roomAvailable = roomAvailable;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    @Override
    public String toString() {
        return "Room " + roomID + " - Roomtype: " + roomType + " - Roomsize: " + roomSize + " - Available : " +
                roomAvailable + " - Date ready: " + dateReady + "\n";

    }
}
