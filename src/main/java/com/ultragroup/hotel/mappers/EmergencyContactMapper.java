package com.ultragroup.hotel.mappers;

import com.ultragroup.hotel.models.dtos.EmergencyContactDTO;
import com.ultragroup.hotel.models.entities.EmergencyContact;
import com.ultragroup.hotel.models.entities.Reservation;
import java.util.List;


public interface EmergencyContactMapper {
    EmergencyContactDTO emergencyToEmergencyDTO(EmergencyContact emergencyContact);

    EmergencyContact emergencyContactDTOToEmergencyContact(EmergencyContactDTO emergencyContactDTO );
}
