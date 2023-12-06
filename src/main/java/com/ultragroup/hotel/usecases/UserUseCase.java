package com.ultragroup.hotel.usecases;

import com.ultragroup.hotel.models.dtos.UserDTO;
import com.ultragroup.hotel.models.entities.User;
import org.springframework.http.ResponseEntity;

public interface UserUseCase {
    UserDTO registerUser(UserDTO user);

    UserDTO login(UserDTO userDTO);
}
