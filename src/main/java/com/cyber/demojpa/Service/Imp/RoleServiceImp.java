package com.cyber.demojpa.Service.Imp;

import com.cyber.demojpa.Service.RoleService;
import com.cyber.demojpa.dto.RoleDTO;
import com.cyber.demojpa.entity.Roles;
import com.cyber.demojpa.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
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
}
