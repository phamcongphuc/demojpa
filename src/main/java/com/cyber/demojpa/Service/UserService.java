package com.cyber.demojpa.Service;

import org.springframework.stereotype.Service;
import com.cyber.demojpa.dto.UserDTO;
import com.cyber.demojpa.payload.LoginRequest;
import java.util.List;


@Service
public interface UserService {
  boolean getUserByEmailAndPassword(LoginRequest loginRequest);
  boolean insert(UserDTO userDTO);
  List<UserDTO> getAllUser();
  List<UserDTO> getUserByEmailAndRoleName(String email, String roleName);
  boolean updateUser(UserDTO userDTO, int id);
  boolean deleteUser (int id);

}
