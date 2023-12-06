package com.ultragroup.hotel.services;


import com.ultragroup.hotel.config.exceptions.MessageException;
import com.ultragroup.hotel.models.entities.User;
import com.ultragroup.hotel.repositories.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Objects;


@Slf4j
@Service
public class
UserService {

    @Autowired
    UserRepository userRepository;


    public User registerUser(User user) {

        User userExist = userRepository.findByEmail(user.getEmail());
        if (!Objects.isNull(userExist)) {
            throw new MessageException("El usuario ya está registrado con ese email");
        }

        return userRepository.save(user);
    }


    public User login(User user) {
        User userR =userRepository.findByEmail(user.getEmail());
        if (Objects.isNull(userR)) {
            throw new MessageException("El usuario no está registrado con ese email");
        }

        return userR;
    }


}
