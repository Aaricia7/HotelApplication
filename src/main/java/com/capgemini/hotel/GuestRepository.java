package com.capgemini.hotel;
import com.capgemini.Demo;
import java.util.ArrayList;

public class GuestRepository  {

    ArrayList<Guest> guestList = new ArrayList<Guest>();
    public void add(Guest guest) {
        guestList.add(guest);
    }

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



        //for each loop toevoegen die door de arraylist loopt.

}

    public void searchGuest() {

    }
}
