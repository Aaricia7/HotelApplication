package com.capgemini.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.capgemini.hotel.*;

@RestController
@RequestMapping(value="/API/bookings/")
public class BookingController {
    @Autowired
    BookingRepository bookingRepository;

    @RequestMapping(value= "/api/booking", method=RequestMethod.POST)
    public void add(@RequestBody Booking booking) {

        bookingRepository.save(booking);
    }
}