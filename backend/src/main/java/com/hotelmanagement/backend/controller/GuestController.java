package com.hotelmanagement.backend.controller;

import com.hotelmanagement.backend.entity.Guest;
import com.hotelmanagement.backend.repository.GuestRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/guests")
@CrossOrigin(origins = "*")
public class GuestController {

    private final GuestRepository guestRepository;

    public GuestController(GuestRepository guestRepository) {
        this.guestRepository = guestRepository;
    }

    @GetMapping
    public List<Guest> getGuests() {
        return guestRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Guest createGuest(@Valid @RequestBody Guest guest) {
        return guestRepository.save(guest);
    }
}
