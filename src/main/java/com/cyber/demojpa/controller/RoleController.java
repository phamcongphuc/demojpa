package com.cyber.demojpa.controller;


import com.cyber.demojpa.Service.RoleService;

import com.cyber.demojpa.dto.RoleDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    RoleService roleService;

    @GetMapping("")
    public ResponseEntity<?> getAllRole() {

        return new ResponseEntity<>(roleService.getAllRole(), HttpStatus.OK);
    }

    @GetMapping("/{name}")
    public ResponseEntity<?> getRoleByName(@PathVariable String name) {

        return new ResponseEntity<>(roleService.getRoleByName(name), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<?> addRoles(@RequestBody RoleDTO roleDTO) {

        return new ResponseEntity<>(roleService.insertRole(roleDTO), HttpStatus.OK);
    }

    @PostMapping("/{id}")
    public ResponseEntity<?> updateRoles(@RequestBody RoleDTO roleDTO, @PathVariable int id) {

        return new ResponseEntity<>(roleService.updateRole(roleDTO, id), HttpStatus.OK);
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<?> removeRoles(@PathVariable int id) {

        return new ResponseEntity<>(roleService.deleteRole(id), HttpStatus.OK);
    }

}
