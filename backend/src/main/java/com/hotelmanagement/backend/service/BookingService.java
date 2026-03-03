package com.hotelmanagement.backend.service;

import com.hotelmanagement.backend.dto.BookingRequest;
import com.hotelmanagement.backend.entity.Booking;
import com.hotelmanagement.backend.entity.Guest;
import com.hotelmanagement.backend.entity.Room;
import com.hotelmanagement.backend.repository.BookingRepository;
import com.hotelmanagement.backend.repository.GuestRepository;
import com.hotelmanagement.backend.repository.RoomRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class BookingService {

    private final BookingRepository bookingRepository;
    private final RoomRepository roomRepository;
    private final GuestRepository guestRepository;

    public BookingService(BookingRepository bookingRepository, RoomRepository roomRepository, GuestRepository guestRepository) {
        this.bookingRepository = bookingRepository;
        this.roomRepository = roomRepository;
        this.guestRepository = guestRepository;
    }

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    public Booking createBooking(BookingRequest request) {
        if (!request.getCheckInDate().isBefore(request.getCheckOutDate())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Check-out date must be after check-in date.");
        }

        Room room = roomRepository.findById(request.getRoomId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Room not found."));

        Guest guest = guestRepository.findById(request.getGuestId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Guest not found."));

        boolean hasOverlap = !bookingRepository.findByRoomAndCheckOutDateAfterAndCheckInDateBefore(
                room,
                request.getCheckInDate(),
                request.getCheckOutDate()
        ).isEmpty();

        if (hasOverlap) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Room already booked for the selected dates.");
        }

        Booking booking = new Booking();
        booking.setRoom(room);
        booking.setGuest(guest);
        booking.setCheckInDate(request.getCheckInDate());
        booking.setCheckOutDate(request.getCheckOutDate());
        booking.setStatus("CONFIRMED");

        return bookingRepository.save(booking);
    }
}
