package com.ultragroup.hotel.controllers;


import com.ultragroup.hotel.config.exceptions.MessageException;
import com.ultragroup.hotel.models.dtos.HotelDTO;
import com.ultragroup.hotel.usecases.HotelUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("hotel")
@Validated
public class HotelController {


    private final HotelUseCase hotelUseCase;

    public HotelController(HotelUseCase hotelUseCase) {
        this.hotelUseCase = hotelUseCase;
    }

    @PostMapping
    public ResponseEntity<HotelDTO> create(@RequestBody @Valid HotelDTO request) {
        try {
            HotelDTO response = hotelUseCase.create(request);
            return ResponseEntity.ok(response);
        } catch (MessageException e) {
            return ResponseEntity.badRequest().body(HotelDTO.builder().message(e.getMessage()).build());
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable long id, @RequestBody HotelDTO updatedHotel) {
        Optional<HotelDTO> updatedHotelDTO = hotelUseCase.updated(updatedHotel.getId(), updatedHotel);

        if (updatedHotelDTO.isPresent()) {
            return ResponseEntity.ok(updatedHotelDTO.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping
    public ResponseEntity<List<HotelDTO>> getHotels() {
        return ResponseEntity.ok(hotelUseCase.getAllHotels());
    }

    @GetMapping("/{id}")
    public ResponseEntity<HotelDTO> getHotelById(@PathVariable Long id) {
        ResponseEntity<HotelDTO> hotelDTO = hotelUseCase.getHotelById(id);
        return hotelDTO;
    }

    @GetMapping("/active")
    public ResponseEntity<List<HotelDTO>> getHotelsByActive(@RequestParam boolean isActive) {
        List<HotelDTO> hotelDTOList = hotelUseCase.getHotelsByActive(isActive);
        return ResponseEntity.ok(hotelDTOList);
    }
}

