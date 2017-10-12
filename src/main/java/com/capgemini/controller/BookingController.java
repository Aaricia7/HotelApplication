package com.capgemini.controller;

import com.capgemini.repository.BookingRepository;
import com.capgemini.repository.GuestRepository;
import com.capgemini.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import com.capgemini.hotel.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

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
    public void add(@Valid @RequestBody Booking booking) {
        Guest guest = guestRepository.findOne(booking.getGuestID());
        Room room = roomRepository.findOne(booking.getRoomID());
        if(room!=null && guest!=null) {
            booking.setGuest(guest);
            booking.setRoom(room);
            bookingRepository.save(booking);
        }
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public Iterable<Booking> GetAll() {
        return bookingRepository.findAll();
    }

    @RequestMapping(value = "{id}/" , method = RequestMethod.GET)
    public Booking get(@PathVariable long id) {
       return bookingRepository.findOne(id);}

    @RequestMapping(value= "{id}/" , method= RequestMethod.DELETE)
    public void del (@PathVariable long id) {
        bookingRepository.delete(id);
    }

    @RequestMapping(value="", method=RequestMethod.PUT)
    public void save(@Valid @RequestBody Booking booking) {
        Guest guest = guestRepository.findOne(booking.getGuestID());
        Room room = roomRepository.findOne(booking.getRoomID());
        if(room!=null && guest!=null) {
            booking.setGuest(guest);
            booking.setRoom(room);
            bookingRepository.save(booking);
        }
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
}
