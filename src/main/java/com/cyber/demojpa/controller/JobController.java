package com.cyber.demojpa.controller;

import com.cyber.demojpa.Service.JobService;
import com.cyber.demojpa.dto.JobDTO;
import com.cyber.demojpa.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

@RestController
@RequestMapping("/job")
public class JobController {

    @Autowired
    JobService jobService;

    @GetMapping("")
    public ResponseEntity<?> getAllJob(){
        return new ResponseEntity<>(jobService.getAllJob(), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<?> saveJob(@RequestBody JobDTO jobDTO)  {
        return  new ResponseEntity<>(jobService.insertJob(jobDTO),HttpStatus.OK);
    }
    @PostMapping("/{id}")
    public ResponseEntity<?> updateUser(@RequestBody JobDTO jobDTO, @PathVariable int id) {

        return new ResponseEntity<>(jobService.updateJob(jobDTO, id), HttpStatus.OK);
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<?> removeUser(@PathVariable int id) {

        return new ResponseEntity<>(jobService.deleteJob(id), HttpStatus.OK);
    }
}
