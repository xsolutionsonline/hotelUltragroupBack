package com.ultragroup.hotel.mappers;

import com.ultragroup.hotel.models.dtos.UserDTO;
import com.ultragroup.hotel.models.entities.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapperImpl implements  UserMapper{

    public UserDTO userToUserDTO(User user) {
        return UserDTO.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .birthDate(user.getBirthDate())
                .contact(user.getContact())
                .email(user.getEmail())
                .password(user.getPassword())
                .active(user.isActive())
                .gender(user.getGender())
                .documentType(user.getDocumentType())
                .documentNumber(user.getDocumentNumber())
                .phoneNumber(user.getPhoneNumber())
                .build();
    }


    @Override
    public User userDTOToUser(UserDTO userDTO) {
        return User.builder()
                .id(userDTO.getId())
                .firstName(userDTO.getFirstName())
                .lastName(userDTO.getLastName())
                .birthDate(userDTO.getBirthDate())
                .contact(userDTO.getContact())
                .email(userDTO.getEmail())
                .password(userDTO.getPassword())
                .active(userDTO.isActive())
                .gender(userDTO.getGender())
                .documentType(userDTO.getDocumentType())
                .documentNumber(userDTO.getDocumentNumber())
                .phoneNumber(userDTO.getPhoneNumber())
                .build();
    }

}
