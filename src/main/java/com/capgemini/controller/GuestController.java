package com.capgemini.controller;

import com.capgemini.hotel.Guest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/Guest/")
public class GuestController {

    @RequestMapping("/api/guest")
    public Guest home() {
        Guest guest = new Guest("Aaricia", "van Oostrom", "Lijsterlaan 1",
                "3135 KL", "Vlaardingen", "Nederland", "0621895051",
                "aaricia.van-oostrom@capgemini.com", 1);
        return guest;
    }


//    @RequestMapping(value ="", method=RequestMethod.PUT )
//    public void update(@RequestBody Guest guest)  {
//        save(guest);
//    }
//
//    @RequestMapping(value ="", method=RequestMethod.POST )
//    public void update(@RequestBody Guest guest)  {
//        add(guest);
//    }



}