package com.cyber.demojpa.Service.Imp;

import com.cyber.demojpa.Service.UserService;
import com.cyber.demojpa.dto.UserDTO;
import com.cyber.demojpa.entity.Roles;
import com.cyber.demojpa.entity.Tasks;
import com.cyber.demojpa.entity.Users;
import com.cyber.demojpa.payload.LoginRequest;
import com.cyber.demojpa.repository.RoleRepository;
import com.cyber.demojpa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.relation.Role;
import java.lang.annotation.Target;
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
        Roles roles = new Roles();

        for (Users users : userRepository.getAllUser()) {
            UserDTO userDTO = new UserDTO();

            userDTO.setEmail(users.getEmail());
            userDTO.setFullName(users.getFullName());
            userDTO.setPassword(users.getPassword());
            userDTO.setAvatar(users.getAvatar());
            userDTO.setRoleId(users.getRoles().getId());

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

    @Override
    public boolean updateUser(UserDTO userDTO, int id) {
        Optional<Users> rolesOptional = userRepository.findById(id);
        Roles roles = new Roles();
        roles.setId(userDTO.getRoleId());

        try {
            Users users = rolesOptional.get();
            users.setEmail(userDTO.getEmail());
            users.setPassword(userDTO.getPassword());
            users.setFullName(userDTO.getFullName());
            users.setRoles(roles);

            userRepository.save(users);
            return true;
        } catch (Exception e) {
            System.out.println("Lỗi update users: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean deleteUser(int id) {
        try {
            userRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            System.out.println("Lỗi delete users: " + e.getMessage());
            return false;
        }
    }
}
