package com.cyber.demojpa.Service;

import com.cyber.demojpa.dto.JobDTO;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;

@Service
public interface JobService {
    List<JobDTO> getAllJob();
    boolean insertJob(JobDTO jobDTO) ;
    boolean updateJob(JobDTO jobDTO, int id);
    boolean deleteJob(int id);
}
