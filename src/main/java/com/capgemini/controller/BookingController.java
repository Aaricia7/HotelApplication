package com.capgemini.controller;

import com.capgemini.repository.BookingRepository;
import com.capgemini.repository.GuestRepository;
import com.capgemini.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.capgemini.hotel.*;

@RestController
@RequestMapping("/api/bookings/")
public class BookingController {

    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    GuestRepository guestRepository;

    @Autowired
    RoomRepository roomRepository;

    @RequestMapping(value= "", method=RequestMethod.POST)
    public void add(@RequestBody Booking booking) {

        bookingRepository.save(booking);
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public Iterable<Booking> GetAll() {
        return bookingRepository.findAll();
    }

    @RequestMapping(value = "{id}/" , method = RequestMethod.GET)
    public Booking get (@PathVariable long id) {
       return bookingRepository.findOne(id);}

    @RequestMapping(value= "{id}/" , method= RequestMethod.DELETE)
    public void del (@PathVariable long id) {
        bookingRepository.delete(id);
    }}

//    createx/readx/delete/update