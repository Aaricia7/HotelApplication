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

import java.time.LocalDate;

import static com.capgemini.hotel.ERoomSize.EENPERSOONS;

@SpringBootApplication
public class App
{
    public static void main(String[] args)  {
        SpringApplication.run(App.class, args);
    }

//    @Bean
//    public CommandLineRunner demo(GuestRepository repository) {
//        return(args) -> {
//            repository.save(new Guest("Aaricia", "van Oostrom", "Lijsterlaan 1", "3135KL",
//                    "Vlaardingen", "Nederland", "0621895051", "aariciavo@gmail.com"));
//        };
//    }

    @Autowired
    public CommandLineRunner demo1(RoomRepository repository) {
        return(args) -> {
            repository.save(new Room(ERoomSize.TWEEPERSOONS,ERoomType.BUDGET,true, null, "100"));
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
