package com.example.jwttest.service;

import com.example.jwttest.dto.UserDTO;
import com.example.jwttest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    // C
    public UserDTO insertUser(UserDTO user) {
        return userRepository.insertUser(user);
    }

    // R
    public List<UserDTO> getAllUsers() {
        return userRepository.getAllUsers();
    }

    // R
    public UserDTO getUserByUserId(String userId) {
        return userRepository.getUserByUserId(userId);
    }

    // U
    public void updateUserPw(String userId, UserDTO user) {
        userRepository.updateUserPw(userId, user);
    }

    // D
    public void deleteUser(String userId) {
        userRepository.deleteUser(userId);
    }




}
