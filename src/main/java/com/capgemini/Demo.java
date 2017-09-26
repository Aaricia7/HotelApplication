package com.capgemini;

import com.capgemini.hotel.*;
import com.sun.org.apache.xpath.internal.SourceTree;
import java.util.ArrayList;

public class Demo {


    public static void main(String[] args) {
        Room room1 = new Room(1, 4, "Luxe", true, "now");
        Room room2 = new Room(2, 2, "Business",true, "now");
        Room room3 = new Room(3, 6, "Budget", true,"now");
        Room room4 = new Room(4, 6, "Luxe", false,"30-09-2017");
        Room room5 = new Room(5, 2, "Business",false, "31-09-2017");

        Guest guest1 = new Guest("Tom", "Hanks","West 12", "4567",
                "New York", "United States", "555-1234", "tom@hanks.com");



        ArrayList<Room> roomList = new ArrayList<Room>();
        roomList.add(room1);
        roomList.add(room2);
        roomList.add(room3);
        roomList.add(room4);
        roomList.add(room5);

//        StringBuilder roomListSB = new StringBuilder();
//        for (Room value : roomList) {
//            roomListSB.append(value);
//        } String testRoomListSB = roomListSB.toString();
//        System.out.println("Rooms: \n" + testRoomListSB);

        System.out.println("Rooms: \n" + roomList.toString());



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