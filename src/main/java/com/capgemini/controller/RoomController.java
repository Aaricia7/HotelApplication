package com.capgemini.controller;
import com.capgemini.hotel.ERoomSize;
import com.capgemini.hotel.Guest;
import com.capgemini.hotel.Room;
import com.capgemini.repository.RoomRepository;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

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
    public void add(@Valid @RequestBody Room room) {
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
    public void save(@Valid @RequestBody Room room) {
        roomRepository.save(room);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public List<String> processValidationError(MethodArgumentNotValidException ex) {
        BindingResult result = ex.getBindingResult();
        List<FieldError> fieldErrors = result.getFieldErrors();
        ArrayList<String> errors = new ArrayList<>();
        for (FieldError field : fieldErrors){
            errors.add(field.getDefaultMessage());
        }
        return errors;
    }

    //ConstraintViolationException

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public String processConstraintError(ConstraintViolationException ex) {
        return "Deze kamer is geboekt.";
    }


}