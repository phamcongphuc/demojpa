package com.cyber.demojpa.Service.Imp;

import com.cyber.demojpa.Service.UserService;
import com.cyber.demojpa.dto.UserDTO;
import com.cyber.demojpa.entity.Roles;
import com.cyber.demojpa.entity.Users;
import com.cyber.demojpa.payload.LoginRequest;
import com.cyber.demojpa.repository.RoleRepository;
import com.cyber.demojpa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImp implements UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;


    @Override
    public boolean getUserByEmailAndPassword(LoginRequest loginRequest) {
        return userRepository.findByEmailAndPassword(loginRequest.getEmail(), loginRequest.getPassword()).size() > 1;
    }

    @Override
    public Users addUser(UserDTO userDTO) {
        Users users = new Users();
        users.setEmail(userDTO.getEmail());
        users.setFullName(userDTO.getFullName());
        users.setPassword(userDTO.getPassword());
        users.setAvatar(userDTO.getAvatar());
        users.setRoles(roleRepository.findById(userDTO.getRoleId()).get());

        return userRepository.save(users);
    }

    @Override
    public boolean insert(UserDTO userDTO) {
        Roles roles = new Roles();
        roles.setId(userDTO.getRoleId());

        Users users = new Users();
        users.setEmail(userDTO.getEmail());
        users.setFullName(userDTO.getFullName());
        users.setPassword(userDTO.getPassword());
        users.setAvatar(userDTO.getAvatar());
        users.setRoles(roles);

        try {
            userRepository.save(users);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public List<UserDTO> getAllUser() {
        List<UserDTO> list = new ArrayList<>();
        for (Users users : userRepository.getAllUser()) {
            UserDTO userDTO = new UserDTO();
            userDTO.setEmail(users.getEmail());
            userDTO.setFullName(users.getFullName());
            userDTO.setPassword(users.getPassword());
            userDTO.setAvatar(users.getAvatar());

            list.add(userDTO);
        }
        return list;
    }

    @Override
    public List<UserDTO> getUserByEmailAndRoleName(String email, String roleName) {
        List<UserDTO> list = new ArrayList<>();
        for (Users users : userRepository.getAllUserByEmailAndRoleName(email, roleName)) {
            UserDTO userDTO = new UserDTO();
            userDTO.setEmail(users.getEmail());
            userDTO.setFullName(users.getFullName());
            userDTO.setPassword(users.getPassword());
            userDTO.setAvatar(users.getAvatar());

            list.add(userDTO);
        }
        return list;
    }
}
