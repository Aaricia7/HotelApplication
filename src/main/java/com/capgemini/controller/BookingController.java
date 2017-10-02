package com.capgemini.controller;

import org.springframework.web.bind.annotation.*;
import com.capgemini.hotel.*;

@RestController
public class BookingController {

    @RequestMapping("/api/booking")
    public Booking home() {
        Booking booking = new Booking(1, 1, 1, "26-09-2017", "30-09-2017",
                false);
        return booking;
    }
}