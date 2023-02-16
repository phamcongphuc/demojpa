package com.cyber.demojpa.repository;

import com.cyber.demojpa.dto.RoleDTO;
import com.cyber.demojpa.entity.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.management.relation.Role;
import java.util.List;

// tham số thứ nhất trong JpaRepository<Tên_Entity, kiểu dữ liệu khóa chính>
//@Component, @Service, @Repository, @Bean thường được khai báo Config
@Repository
public interface RoleRepository extends JpaRepository<Roles,Integer> {

    List<Roles> findByName(String name);
   // Roles  findById(int id);
}
