package com.ultragroup.hotel.usecases;

import com.ultragroup.hotel.config.exceptions.MessageException;
import com.ultragroup.hotel.mappers.UserMapper;
import com.ultragroup.hotel.models.dtos.UserDTO;
import com.ultragroup.hotel.models.entities.User;
import com.ultragroup.hotel.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class UserUseCaseImpl  implements UserUseCase{

    @Autowired
    UserService userService;

    @Autowired
    UserMapper userMapper;



        @Override
        public UserDTO registerUser(UserDTO userDTO) {

            User user = userMapper.userDTOToUser(userDTO);
            User createdUser = userService.registerUser(user);

            return userMapper.userToUserDTO(createdUser);
        }

        

    @Override
    public  UserDTO  login(UserDTO userDTO) {
        return  userMapper.userToUserDTO(userService.login(userMapper.userDTOToUser(userDTO)));
    }
}
