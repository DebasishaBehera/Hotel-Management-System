package com.hotelmanagement.backend.repository;

import com.hotelmanagement.backend.entity.Booking;
import com.hotelmanagement.backend.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    List<Booking> findByRoomAndCheckOutDateAfterAndCheckInDateBefore(Room room, LocalDate checkIn, LocalDate checkOut);
}
