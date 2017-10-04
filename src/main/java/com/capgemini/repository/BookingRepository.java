package com.capgemini.repository;

import java.util.List;
import com.capgemini.hotel.Booking;
import org.springframework.data.repository.CrudRepository;

public interface BookingRepository extends CrudRepository<Booking, Long> {

}