package com.cyber.demojpa.Service;

import com.cyber.demojpa.dto.RoleDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RoleService {
    List<RoleDTO> getAllRole();

    List<RoleDTO> getRoleByName(String name);

    boolean insertRole(RoleDTO roleDTO);

    boolean updateRole(RoleDTO roleDTO, int id);

    boolean deleteRole(int id);
}
