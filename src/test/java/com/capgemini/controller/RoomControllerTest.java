package com.capgemini.controller;

import com.capgemini.hotel.Room;
import com.capgemini.repository.RoomRepository;
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
public class RoomControllerTest {

    @InjectMocks
    private RoomController roomController;

    @Mock
    private RoomRepository fakeRepository;

    @Mock
    private Room fakeRoom;

    @Test
    public void testFindAll() {
        when(fakeRepository.findAll()).thenReturn(new ArrayList<>());
        Iterable<Room> result = roomController.getAll();
        Assert.assertEquals(0, result.spliterator().getExactSizeIfKnown());
    }
}
