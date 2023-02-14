package com.cyber.demojpa.Service;

import com.cyber.demojpa.dto.RoleDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RoleService {
     List<RoleDTO> getAllRole();
     List<RoleDTO> getRoleByName(String name);
}
