package com.mercadolibre.desafiospring.aplication.useCase.impl;

import com.mercadolibre.desafiospring.aplication.useCase.UserUseCase;
import com.mercadolibre.desafiospring.domain.User;
import com.mercadolibre.desafiospring.infrastructure.UserRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserUseCaseImpl implements UserUseCase {
    private UserRepository userRepository;

    public UserUseCaseImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void follow(String userId, String userIdToFollow) {
            var userUUID = UUID.fromString(userId);
            var userToFollowUUID = UUID.fromString(userIdToFollow);
            var user = new User(userUUID);
            var userToFollow = new User(userToFollowUUID);
/*
            var userIsValid = userRepository.exist(user);
            var userToFollowIsValid = userRepository.exist(userToFollow);

            if(!userIsValid)throw new IllegalArgumentException("User does not exist");
            if(!userToFollowIsValid)throw  new IllegalArgumentException("following user does not exist");

            user.follow(userToFollow);
            userRepository.save(user);
            userRepository.save(userToFollow);
*/


    }
}
