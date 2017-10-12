package com.capgemini.controller;

import com.capgemini.hotel.Booking;
import com.capgemini.repository.BookingRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.awt.print.Book;
import java.util.ArrayList;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BookingControllerTest {

    @InjectMocks
    BookingController bookingController;

    @Mock
    Booking fakeBooking;

    @Mock
    BookingRepository fakeRepository;

    @Test
    public void testFindAll() {
        //Check of de repository 1x wordt aangeroepen
        //Check of je iets terugkrijgt, zonder manipulaties

        when(fakeRepository.findAll()).thenReturn(new ArrayList<>());
        Iterable<Booking> result = bookingController.GetAll();
        Assert.assertEquals(0, result.spliterator().getExactSizeIfKnown());
    }

    @Test
    public void testFindOne() {
        when(fakeRepository.findOne(1L)).thenReturn(fakeBooking);
        Booking result = bookingController.get(1);
        Assert.assertEquals(fakeBooking, result);
        verify(fakeRepository, times(1)).findOne(1L);
    }

    @Test
    public void testAddGuest() {
        bookingController.save(fakeBooking);
        verify(fakeRepository, times(1)).save(fakeBooking);
    }

    @Test
    public void testDeleteGuest() {
        bookingController.del(1L);
        verify(fakeRepository, times(1)).delete(1L);
    }

    @Test(expected = Exception.class)
    public void testFindGuestNotFound() {
        when(fakeRepository.findOne(1L)).thenThrow(new Exception());
        bookingController.get(1);
    }

}
