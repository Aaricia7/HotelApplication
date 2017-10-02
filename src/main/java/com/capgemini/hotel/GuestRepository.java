package com.capgemini.hotel;
import java.util.ArrayList;

public class GuestRepository  {


    ArrayList<Guest> guestList = new ArrayList<Guest>();
    //ArrayList<Guest> getGuestList;

    public void add(Guest guest) {
        guestList.add(guest);
    }

//    public Guest getGuestList(ArrayList guest) {
//        return guestList.get(guest);
//    }

    public boolean check(Guest guest){
        for (Guest guests: guestList) {
            if (guests.getGuestLastName() == guest.getGuestLastName())
                return true;
        }
        return false;

    }
    public void registerGuest() {

    }

    public void deleteGuest() {

    }

    public void checkGuest() {


}

}
