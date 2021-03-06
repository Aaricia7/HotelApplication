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

    @Test
    public void testFindOne() {
        when(fakeRepository.findOne(1L)).thenReturn(fakeRoom);
        Room result = roomController.get(1);
        Assert.assertEquals(fakeRoom, result);
        verify(fakeRepository, times(1)).findOne(1L);
    }

    @Test
    public void testAddRoom() {
        roomController.save(fakeRoom);
        verify(fakeRepository, times(1)).save(fakeRoom);
    }

    @Test
    public void testDeleteRoomt() {
        roomController.del(1L);
        verify(fakeRepository, times(1)).delete(1L);
    }

    @Test(expected = Exception.class)
    public void testFindRoomNotFound() {
        when(fakeRepository.findOne(1L)).thenThrow(new Exception());
        roomController.get(1);
    }
}
