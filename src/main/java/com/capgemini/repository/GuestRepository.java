package com.capgemini.repository;

import java.util.List;

import com.capgemini.hotel.Guest;
import org.springframework.data.repository.CrudRepository;

public interface GuestRepository extends CrudRepository<Guest, Long> {

}