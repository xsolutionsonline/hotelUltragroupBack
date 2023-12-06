package com.ultragroup.hotel.services;

import com.ultragroup.hotel.models.entities.Hotel;
import com.ultragroup.hotel.repositories.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class HotelService {
    @Autowired
    private HotelRepository hotelRepository;



    public Hotel create(Hotel hotel) {
        hotelRepository.save(hotel);
        return hotel;
    }

    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }


    public Optional<Hotel> findById(Long id) {
        return hotelRepository.findById(id);

    }

    public List<Hotel> findByIsActive(boolean isActive) {
        return hotelRepository.findByActive(isActive);
    }
}


