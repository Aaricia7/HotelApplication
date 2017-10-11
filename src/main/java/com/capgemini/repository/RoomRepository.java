package com.capgemini.repository;


import com.capgemini.hotel.Room;
import org.springframework.data.repository.CrudRepository;

public interface RoomRepository extends CrudRepository<Room, Long> {

}