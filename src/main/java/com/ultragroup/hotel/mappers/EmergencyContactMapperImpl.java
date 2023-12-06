package com.ultragroup.hotel.mappers;

import com.ultragroup.hotel.models.dtos.EmergencyContactDTO;
import com.ultragroup.hotel.models.dtos.HotelDTO;
import com.ultragroup.hotel.models.dtos.ReservationDTO;
import com.ultragroup.hotel.models.dtos.UserDTO;
import com.ultragroup.hotel.models.entities.EmergencyContact;
import com.ultragroup.hotel.models.entities.Hotel;
import com.ultragroup.hotel.models.entities.Reservation;
import com.ultragroup.hotel.models.entities.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class EmergencyContactMapperImpl implements  EmergencyContactMapper{

    @Override
    public EmergencyContactDTO emergencyToEmergencyDTO(EmergencyContact emergencyContact) {
        return EmergencyContactDTO.builder()
                .id(emergencyContact.getId())
                .fullName(emergencyContact.getFullName())
                .phoneNumber(emergencyContact.getPhoneNumber())
                .build();
    }

    @Override
    public EmergencyContact emergencyContactDTOToEmergencyContact(EmergencyContactDTO emergencyContactDTO) {
        return EmergencyContact.builder()
                .id(emergencyContactDTO.getId())
                .fullName(emergencyContactDTO.getFullName())
                .phoneNumber(emergencyContactDTO.getPhoneNumber())
                .build();
    }




}
