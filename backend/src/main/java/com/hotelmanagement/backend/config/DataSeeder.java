package com.hotelmanagement.backend.config;

import com.hotelmanagement.backend.entity.Guest;
import com.hotelmanagement.backend.entity.Room;
import com.hotelmanagement.backend.repository.GuestRepository;
import com.hotelmanagement.backend.repository.RoomRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSeeder {

    @Bean
    CommandLineRunner seedData(RoomRepository roomRepository, GuestRepository guestRepository) {
        return args -> {
            if (roomRepository.count() == 0) {
                Room deluxe = new Room();
                deluxe.setRoomNumber("101");
                deluxe.setType("DELUXE");
                deluxe.setCapacity(2);
                deluxe.setPricePerNight(150.0);
                deluxe.setAvailable(true);

                Room suite = new Room();
                suite.setRoomNumber("201");
                suite.setType("SUITE");
                suite.setCapacity(4);
                suite.setPricePerNight(300.0);
                suite.setAvailable(true);

                roomRepository.save(deluxe);
                roomRepository.save(suite);
            }

            if (guestRepository.count() == 0) {
                Guest guest = new Guest();
                guest.setFullName("John Doe");
                guest.setEmail("john@example.com");
                guest.setPhone("+1234567890");
                guestRepository.save(guest);
            }
        };
    }
}
