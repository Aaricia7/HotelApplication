package com.capgemini.controller;

import com.capgemini.hotel.Guest;
import com.capgemini.repository.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/guests/")
public class GuestController {

    @Autowired
    GuestRepository guestRepository;

    @RequestMapping(value="",method = RequestMethod.GET)
    public Iterable<Guest> getAll() {
        return guestRepository.findAll();
    }

    @RequestMapping(value="", method=RequestMethod.POST)
    public void add(@RequestBody Guest guest) {
        guestRepository.save(guest);
    }

    @RequestMapping(value="{id}/", method= RequestMethod.DELETE)
    public void del(@PathVariable long id) {
        guestRepository.delete(id);
    }

    @RequestMapping(value="{id}/", method= RequestMethod.GET)
    public Guest get(@PathVariable long id) {
        return guestRepository.findOne(id);
    }

}