package com.cyber.demojpa.Service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.cyber.demojpa.dto.UserDTO;
import com.cyber.demojpa.entity.Users;
import com.cyber.demojpa.payload.LoginRequest;

import java.util.List;


@Service
public interface UserService {
  boolean getUserByEmailAndPassword(LoginRequest loginRequest);
  Users addUser(UserDTO userDTO);
  boolean insert(UserDTO userDTO);
  List<UserDTO> getAllUser();

  List<UserDTO> getUserByEmailAndRoleName(String email, String roleName);
 // boolean loginEmail(LoginRequest loginRequest);
  // List<UserDTO> (String email, String fullName, String password, String avatar, int roleId);
}
