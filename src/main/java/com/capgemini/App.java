package com.capgemini;

import com.capgemini.hotel.*;
import com.capgemini.repository.BookingRepository;
import com.capgemini.repository.GuestRepository;
import com.capgemini.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;

@SpringBootApplication
public class App
{

    private static final Logger log = LoggerFactory.getLogger(App.class);

    public static void main(String[] args)  {
        SpringApplication.run(App.class, args);
    }

    @Bean
    public CommandLineRunner demo(GuestRepository repository) {
        return(args) -> {
            repository.save(new Guest("Aaricia", "van Oostrom", "Lijsterlaan 1", "3135KL",
                    "Vlaardingen", "Nederland", "0621895051", "aariciavo@gmail.com"));
            log.info("Customers found with findAll():");
            log.info("-------------------------------");
            for (Guest guest : repository.findAll()) {
                log.info(guest.toString());
            }
            log.info("");
        };
    }

//    @Bean
//    public CommandLineRunner demo2(RoomRepository repository) {
//        return(args) -> {
//            repository.save(new Room(ERoomSize.EENPERSOONS, ERoomType.BUDGET, true, LocalDate.now(), "201"));
//        };
//    }
//
//    @Bean
//    public CommandLineRunner demo3(BookingRepository repository) {
//        return(args) -> {
//            repository.save(new Booking(1, 1, LocalDate.now(), LocalDate.now(), false));
//        };
//    }




}
