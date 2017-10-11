package com.capgemini.controller;

import com.capgemini.hotel.Guest;
import com.capgemini.repository.GuestRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class GuestControllerTest {

    @InjectMocks
    private GuestController guestController;

    @Mock
    private GuestRepository repository;

    @Mock
    private Guest guest;

    @Test
    public void testFindAll() {
        //Check of de repository 1x wordt aangeroepen
        //Check of je iets terugkrijgt, zonder manipulaties

        when(repository.findAll()).thenReturn(new ArrayList<Guest>());
        Iterable<Guest> result = guestController.getAll();
        Assert.assertEquals(0, result.spliterator().getExactSizeIfKnown());
    }

    @Test
    public void testFindOne() {
        when(repository.findOne(1L)).thenReturn(guest);
        Guest result = guestController.get(1);
        Assert.assertEquals(guest, result);
        verify(repository, times(1)).findOne(1L);
    }

    @Test
    public void testAddGuest() {
        guestController.save(guest);
        verify(repository, times(1)).save(guest);
    }

    @Test
    public void testDeleteGuest() {
        guestController.del(1L);
        verify(repository, times(1)).delete(1L);
    }

    @Test(expected = Exception.class)
    public void testFindGuestNotFound() {
        when(repository.findOne(1L)).thenThrow(new Exception());
        guestController.get(1);
    }
}
