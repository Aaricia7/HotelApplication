package com.capgemini.controller;

import com.capgemini.hotel.Room;
import org.springframework.web.bind.annotation.*;

@RestController
public class RoomController {

    @RequestMapping("/api/Room")
    public String home() {
        Room room1 = new Room(1, 4, "Luxe", "now");
        return room1.toString();

    }
}