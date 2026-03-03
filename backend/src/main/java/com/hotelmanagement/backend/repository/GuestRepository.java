package com.hotelmanagement.backend.repository;

import com.hotelmanagement.backend.entity.Guest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuestRepository extends JpaRepository<Guest, Long> {
}
