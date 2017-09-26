package com.capgemini;

import com.capgemini.hotel.*;
import com.sun.org.apache.xpath.internal.SourceTree;
import java.util.ArrayList;

public class Demo {


    public static void main(String[] args) {
        Room room1 = new Room(1, 4, "Luxe", "now");
        Room room2 = new Room(2, 2, "Business", "now");
        Room room3 = new Room(3, 6, "Budget", "now");
        Room room4 = new Room(4, 6, "Luxe", "30-09-2017");
        Room room5 = new Room(5, 2, "Business", "31-09-2017");

        ArrayList<Room> availableRooms = new ArrayList<Room>();
        availableRooms.add(room1);
        availableRooms.add(room2);
        availableRooms.add(room3);

        ArrayList<Room> rentedRooms = new ArrayList<Room>();
        rentedRooms.add(room4);

        ArrayList<Room> maintenanceRooms = new ArrayList<Room>();
        maintenanceRooms.add(room5);

        StringBuilder availableRoomsSB = new StringBuilder();
        for (Room value : availableRooms) {
            availableRoomsSB.append(value);
        }
        String textAvailableRooms = availableRoomsSB.toString();

        StringBuilder rentedRoomsSb = new StringBuilder();
        for (Room value : rentedRooms) {
            rentedRoomsSb.append(value);
        }
        String textRentedRooms = rentedRoomsSb.toString();

        StringBuilder maintenanceRoomsSb = new StringBuilder();
        for (Room value : maintenanceRooms) {
            maintenanceRoomsSb.append(value);
        }
        String textMaintenaceRooms = maintenanceRoomsSb.toString();


        System.out.println("Available Rooms: \n" + textAvailableRooms);
        System.out.println("Rented Rooms: \n" + textRentedRooms);
        System.out.println("Maintenance Rooms: \n" + textMaintenaceRooms);


        //  System.out.println(formattedString.toString());
        //System.out.println(roomList.get(2));

        room2.setDateReady("21-05-2014");

//        System.out.println("\n");
//        System.out.println(formattedString.toString());


//        room1.setRoomID(1);
//        Guest guest1 = new Guest("Richard", "Smith", "Springlaan", "8765AM",
//                "Amsterdam", "Nederland","0624242526", "blabla@hotmail.com");
//        System.out.println(room1.getRoomID());
//        System.out.println(room1.getRoomType());
//        room1.setRoomID(2);
//        System.out.println(room1.getRoomID());
//        System.out.println(guest1.getAllGuestDetails());
//        Booking booking1 = new Booking(1,123,1,"01-05-2018", "10-05-2018",false);
//        System.out.println(booking1.isGuestPaid());

    }
}