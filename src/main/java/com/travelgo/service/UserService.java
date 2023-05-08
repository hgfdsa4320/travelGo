package com.travelgo.service;

import com.travelgo.domain.User;
import com.travelgo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User login(String emailAddress, String password) {
        return userRepository.findByMailAddress(emailAddress)
                .filter(user -> user.getPassword().equals(password))
                .orElse(null);
    }
}
