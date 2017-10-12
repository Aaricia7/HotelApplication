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

    public static void main(String[] args)  {
        SpringApplication.run(App.class, args);
    }
}





