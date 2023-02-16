package com.cyber.demojpa.Service.Imp;

import com.cyber.demojpa.Service.RoleService;
import com.cyber.demojpa.dto.RoleDTO;
import com.cyber.demojpa.entity.Roles;
import com.cyber.demojpa.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceImp implements RoleService {
    @Autowired
    RoleRepository roleRepository;

    @Override
    public List<RoleDTO> getAllRole() {
        List<Roles> list = roleRepository.findAll();
        List<RoleDTO> dtoList = new ArrayList<>();
        for (Roles data : list) {
            RoleDTO dto = new RoleDTO();
            dto.setId(data.getId());
            dto.setName(data.getName());
            dto.setDesc(data.getDesc());

            dtoList.add(dto);
        }
//        System.out.println(list);

        return dtoList;
    }

    @Override
    public List<RoleDTO> getRoleByName(String name) {
        List<Roles> list = roleRepository.findByName(name);
        List<RoleDTO> dtoList = new ArrayList<>();

        for (Roles data : list) {
            RoleDTO dto = new RoleDTO();
            dto.setId(data.getId());
            dto.setName(data.getName());
            dto.setDesc(data.getDesc());

            dtoList.add(dto);
        }

        return dtoList;
    }

    @Override
    public boolean insertRole(RoleDTO roleDTO) {
        Roles roles = new Roles();
        roles.setName(roleDTO.getName());
        roles.setDesc(roleDTO.getDesc());

        try {
            roleRepository.save(roles);
            return true;
        } catch (Exception e) {
            System.out.println("Lỗi add roles: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean updateRole(RoleDTO roleDTO, int id) {
        Optional<Roles> rolesOptional = roleRepository.findById(id);

        try {
            Roles roles = rolesOptional.get();
            roles.setName(roleDTO.getName());
            roles.setDesc(roleDTO.getDesc());

            roleRepository.save(roles);
            return true;
        } catch (Exception e) {
            System.out.println("Lỗi update roles: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean deleteRole(int id) {
        try {
            roleRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            System.out.println("Lỗi delete roles: " + e.getMessage());
            return false;
        }
    }
}
