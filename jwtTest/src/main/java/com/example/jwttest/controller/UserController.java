package com.example.jwttest.controller;

import com.example.jwttest.dto.UserDTO;
import com.example.jwttest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    // CRUD
    // C -> POST
    // R -> GET
    // U -> PUT
    // D -> DELETE

    @PostMapping("")  //RequestBody _ json으로 받아오자
    public UserDTO insertUser(@RequestBody UserDTO user) {
        return  userService.insertUser(user);
    }

    @GetMapping("")
    public List<UserDTO> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{userId}") //PathVariable userId의 값이 파라미터로 매핑되어 들어감
    public UserDTO getUserByUserId(@PathVariable String userId) {

        return userService.getUserByUserId(userId);
    }

    @PutMapping("/{userId}")
    public void updateUserPw(@PathVariable String userId, @RequestBody UserDTO user) {
        userService.updateUserPw(userId, user);
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable String userId) {

        userService.deleteUser(userId);
    }


}
