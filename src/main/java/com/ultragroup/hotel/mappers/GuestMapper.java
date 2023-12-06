package com.ultragroup.hotel.mappers;

import com.ultragroup.hotel.models.dtos.GuestDTO;
import com.ultragroup.hotel.models.dtos.UserDTO;
import com.ultragroup.hotel.models.entities.Guest;
import com.ultragroup.hotel.models.entities.User;

public interface GuestMapper {
    GuestDTO userToUserDTO(Guest guest);

    Guest userDTOToUser(GuestDTO guestDTO);
}
