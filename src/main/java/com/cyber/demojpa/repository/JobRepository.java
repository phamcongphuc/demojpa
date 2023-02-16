package com.cyber.demojpa.repository;

import com.cyber.demojpa.entity.Jobs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepository extends JpaRepository<Jobs, Integer> {

}
