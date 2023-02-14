package com.cyber.demojpa.controller;

import com.cyber.demojpa.Service.UserService;
import com.cyber.demojpa.dto.UserDTO;
import com.cyber.demojpa.payload.LoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("")
    public ResponseEntity<?> getAllUser() {
        return new ResponseEntity<>(userService.getAllUser(), HttpStatus.OK);
    }
    @GetMapping("getEmail")
    public ResponseEntity<?> getAllUserByEmailAndRole(@RequestParam("email") String email,
                                                      @RequestParam("roleName") String roleName) {
        return new ResponseEntity<>(userService.getUserByEmailAndRoleName(email,roleName), HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<?> getUserByEmailAndPassword(@RequestBody LoginRequest loginRequest) {
        return new ResponseEntity<>(userService.getUserByEmailAndPassword(loginRequest), HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<?> saveUser(@RequestBody UserDTO userDTO){
        return  new ResponseEntity<>(userService.insert(userDTO),HttpStatus.OK);
    }

//    @PostMapping("/add")
//    public ResponseEntity<?> insertUser(@RequestBody UserDTO userDTO) {
//        // Users user = userService.addUser(userDTO);
//
//        return new ResponseEntity<>(userService.addUser(userDTO), HttpStatus.OK);
//    }

//    @PostMapping("/a")
//    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
//        return new ResponseEntity<>(userService.loginEmail(request), HttpStatus.OK);
//    }

}
