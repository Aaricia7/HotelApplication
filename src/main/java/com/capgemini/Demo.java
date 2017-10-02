package com.capgemini;

import com.capgemini.hotel.*;
import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.ArrayList;

public class Demo {

    static GuestRepository guestRepository= new GuestRepository();
    public static void main(String[] args) {
        Room room1 = new Room(1, ERoomSize.DRIEVIERPERSOONS, ERoomType.BUDGET, true, "now");
        Room room2 = new Room(2, ERoomSize.TWEEPERSOONS, ERoomType.BUSINESS, true, "now");
        Room room3 = new Room(3, ERoomSize.EENPERSOONS, ERoomType.BUDGET, true, "now");
        Room room4 = new Room(4, ERoomSize.TWEEPERSOONS, ERoomType.LUXURIOUS, false, "30-09-2017");
        Room room5 = new Room(5, ERoomSize.TWEEPERSOONS, ERoomType.BUSINESS, false, "31-09-2017");

        Guest guest1 = new Guest("Tom", "Hanks", "West 12", "4567",
                "New York", "United States", "555-1234", "tom@hanks.com", 1);
        Guest guest2 = new Guest("Brad", "Pit", "East 12", "8765",
                "Los Angeles", "United States", "555-7890", "brad@pit.com",2);

        Booking booking1 = new Booking(1,1, 111, "04-11-2017", "22-05-2018", true);
        Booking booking2 = new Booking(2,3, 112, "04-10-2017", "22-03-2018", true);
        Booking booking3 = new Booking(2,2, 113, "04-08-2017", "22-10-2017", false);
        Booking booking4 = new Booking(2,4, 114, "04-10-2017", "22-02-2018", true);
        Booking booking5 = new Booking(2,5, 115, "04-06-2017", "22-07-2017", false);
        Booking booking6 = new Booking(1,1, 116, "04-04-2017", "22-05-2017", true);
        Booking booking7 = new Booking(2,3, 117, "04-02-2017", "22-03-2017", true);
        Booking booking8 = new Booking(2,2, 118, "04-11-2017", "22-02-2018", false);
        Booking booking9 = new Booking(1,1, 119, "04-10-2017", "22-01-2018", true);


        ArrayList<Room> roomList = new ArrayList<Room>();
        roomList.add(room1);
        roomList.add(room2);
        roomList.add(room3);
        roomList.add(room4);
        roomList.add(room5);

        guestRepository.add(guest1);
        guestRepository.add(guest2);

//        StringBuilder roomListSB = new StringBuilder();
//        for (Room value : roomList) {
//            roomListSB.append(value);
//        } String testRoomListSB = roomListSB.toString();
//        System.out.println("Rooms: \n" + testRoomListSB);

        System.out.println("Rooms: \n" + roomList.toString());
        //System.out.println("Guest: \n" + GuestRepository.guestList.toString());
        //  System.out.println(formattedString.toString());
        //System.out.println(roomList.get(2));

    }
}