package com.example.jwttest.repository;

import com.example.jwttest.dto.UserDTO;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {
    //db 연동하는 코드 ...!
    
    //dto를 ArrayList로 받아옴
    static public ArrayList<UserDTO> users;
    
    static {
        users = new ArrayList<>();
        users.add(new UserDTO("kang", "test1", "1234"));
        users.add(new UserDTO("kim", "test2", "5678"));
        users.add(new UserDTO("jeong", "test3", "1288"));
    }
    
    // insert
    public UserDTO insertUser(UserDTO user) {
        users.add(user);
        return user;
    }

    // 전체 목록 조회
    public List<UserDTO> getAllUsers() {
        return users;
    }

    // 개별 조회
    // 하나의 아이디가 dto에 있으면 그것을 리턴하고 없으면 빈 값 리턴
    public UserDTO getUserByUserId(String userId) {
        return users.stream()
                .filter(userDTO -> userDTO.getUserId().equals(userId))
                .findAny()
                .orElse(new UserDTO("", "", ""));
    }
    
    // update
    public void updateUserPw(String userId, UserDTO user) {
        users.stream()
                .filter(userDTO -> userDTO.getUserId().equals(userId))
                .findAny()
                .orElse(new UserDTO("", "", ""))
                .setUserPw(user.getUserPw());
    }
    
    public void deleteUser(String userId){
        users.removeIf(userDTO -> userDTO.getUserId().equals(userId));
    }
    
}
