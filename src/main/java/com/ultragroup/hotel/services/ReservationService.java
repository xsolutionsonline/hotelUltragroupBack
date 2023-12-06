package com.ultragroup.hotel.services;

import com.ultragroup.hotel.models.entities.Hotel;
import com.ultragroup.hotel.models.entities.Reservation;
import com.ultragroup.hotel.repositories.HotelRepository;
import com.ultragroup.hotel.repositories.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;


    @Transactional
    public Reservation create(Reservation reservation) {
        reservationRepository.save(reservation);
        return reservation;
    }

    public List<Reservation> getAllReservation() {
        return reservationRepository.findAll();
    }


    public Optional<Reservation> findById(Long id) {
        return reservationRepository.findById(id);

    }

    public  List<Reservation> findByHotelUserCreatedId(Long id) {
        return reservationRepository.findByHotelUserCreatedId(id);

    }

    public List<Reservation> findByExitDateAfter() {
        return reservationRepository.findByExitDateAfter(new Date());
    }

}


