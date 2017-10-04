package com.capgemini.controller;

import com.capgemini.hotel.ERoomSize;
import com.capgemini.hotel.ERoomType;
import com.capgemini.hotel.Room;
import org.springframework.web.bind.annotation.*;

@RestController
public class RoomController {

    @RequestMapping("/api/room")
    public Room home() {
        Room room1 = new Room(1, ERoomSize.TWEEPERSOONS, ERoomType.BUDGET, true,"now");
        return room1;

    }
}