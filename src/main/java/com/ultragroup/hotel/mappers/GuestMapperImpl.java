package com.ultragroup.hotel.mappers;

import com.ultragroup.hotel.models.dtos.GuestDTO;
import com.ultragroup.hotel.models.entities.Guest;
import org.springframework.stereotype.Component;

@Component
public class GuestMapperImpl implements  GuestMapper{

    public GuestDTO userToUserDTO(Guest user) {
        return GuestDTO.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .birthDate(user.getBirthDate())
                .email(user.getEmail())
                .gender(user.getGender())
                .documentType(user.getDocumentType())
                .documentNumber(user.getDocumentNumber())
                .build();
    }


    @Override
    public Guest userDTOToUser(GuestDTO userDTO) {
        return Guest.builder()
                .id(userDTO.getId())
                .firstName(userDTO.getFirstName())
                .lastName(userDTO.getLastName())
                .birthDate(userDTO.getBirthDate())
                .email(userDTO.getEmail())
                .gender(userDTO.getGender())
                .documentType(userDTO.getDocumentType())
                .documentNumber(userDTO.getDocumentNumber())
                .build();
    }

}
