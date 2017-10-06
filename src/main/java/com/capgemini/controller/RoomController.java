package com.capgemini.controller;
import com.capgemini.hotel.ERoomSize;
import com.capgemini.hotel.Guest;
import com.capgemini.hotel.Room;
import com.capgemini.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

@RestController
@RequestMapping("/api/rooms/")
public class RoomController {

    @Autowired
    RoomRepository roomRepository;

    @RequestMapping(value="",method = RequestMethod.GET)
    public Iterable<Room> getAll() {
        return roomRepository.findAll();
    }

    @RequestMapping(value="", method=RequestMethod.POST)
    public void add(@RequestBody Room room) {
        roomRepository.save(room);
    }

    @RequestMapping(value="{id}/", method= RequestMethod.DELETE)
    public void del(@PathVariable long id) {
        roomRepository.delete(id);
    }

    @RequestMapping(value="{id}/", method= RequestMethod.GET)
    public Room get(@PathVariable long id) {
        return roomRepository.findOne(id);
    }

    @RequestMapping(value="", method=RequestMethod.PUT)
    public void save(@RequestBody Room room) {
        roomRepository.save(room);
    }
}