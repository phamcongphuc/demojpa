package com.cyber.demojpa.Service.Imp;

import com.cyber.demojpa.Service.JobService;
import com.cyber.demojpa.dto.JobDTO;
import com.cyber.demojpa.entity.Jobs;
import com.cyber.demojpa.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class JobServiceImp implements JobService {
    @Autowired
    JobRepository jobRepository;

    @Override
    public List<JobDTO> getAllJob() {
        List<JobDTO> list = new ArrayList<>();

        for (Jobs jobs : jobRepository.findAll()) {
            JobDTO jobDTO = new JobDTO();
            jobDTO.setId(jobs.getId());
            jobDTO.setName(jobs.getName());
            jobDTO.setStartDate(jobs.getStartDate());
            jobDTO.setEndDate(jobs.getEndDate());

            list.add(jobDTO);
        }
        return list;
    }

    @Override
    public boolean insertJob(JobDTO jobDTO) {

        try {
            Jobs jobs = new Jobs();
            jobs.setName(jobDTO.getName());
            jobs.setStartDate(jobDTO.getStartDate());
            jobs.setEndDate(jobDTO.getEndDate());
            jobRepository.save(jobs);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean updateJob(JobDTO jobDTO, int id) {
        Optional<Jobs> jobsOptional = jobRepository.findById(id);
        try {
            Jobs jobs = jobsOptional.get();

            jobs.setName(jobDTO.getName());
            jobs.setStartDate(jobDTO.getStartDate());
            jobs.setEndDate(jobDTO.getEndDate());

            jobRepository.save(jobs);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean deleteJob(int id) {
        try {
            jobRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }


}
