package com.capgemini.controller;

import com.capgemini.hotel.Booking;
import com.capgemini.hotel.Guest;
import com.capgemini.repository.GuestRepository;
import com.capgemini.repository.Validators;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import com.capgemini.repository.BookingRepository;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/guests/")
public class GuestController {

    @Autowired
    GuestRepository guestRepository;

    @Autowired
    BookingRepository bookingRepository;


    @RequestMapping(value="",method = RequestMethod.GET)
    public Iterable<Guest> getAll() {
        return guestRepository.findAll();
    }

    @RequestMapping(value="", method=RequestMethod.POST)
    public void add(@Valid @RequestBody Guest guest) {
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

    @RequestMapping(value="", method=RequestMethod.PUT)
    public void save(@Valid @RequestBody Guest guest) {
        guestRepository.save(guest);
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
        return "Deze gast heeft nog een boeking openstaan.";
    }


}