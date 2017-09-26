package com.capgemini.controller;

import com.capgemini.hotel.Guest;
import org.springframework.web.bind.annotation.*;

@RestController
public class GuestController {

    @RequestMapping("/api/Guest")
    public String home() {
        Guest guest = new Guest("Aaricia", "van Oostrom", "Lijsterlaan 1",
                "3135 KL", "Vlaardingen", "Nederland", "0621895051",
                "aariciavo@gmail.com");
        return guest.toString();
    }
}
