package com.ultragroup.hotel.mappers;

import com.ultragroup.hotel.models.dtos.UserDTO;
import com.ultragroup.hotel.models.entities.User;

public interface UserMapper {
    UserDTO userToUserDTO(User user);

    User userDTOToUser(UserDTO userDTO);
}
