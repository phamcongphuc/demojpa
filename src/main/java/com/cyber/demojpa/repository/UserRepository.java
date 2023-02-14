package com.cyber.demojpa.repository;

import com.cyber.demojpa.entity.Roles;
import com.cyber.demojpa.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

// tham số thứ nhất trong JpaRepository<Tên_Entity, kiểu dữ liệu khóa chính>
//@Component, @Service, @Repository, @Bean thường được khai báo Config
@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {

   List<Users> findByEmailAndPassword(String email, String password);

   // đây là câu query bằng JPQL này tương tác entity
   @Query("select u from users u")
   List<Users> getAllUser();

   @Query(value = "select u from users u " +
           "join roles r " +
           "on u.roles.id = r.id where u.email = ?1 and r.name = ?2 ", nativeQuery = true   )
   List<Users> getAllUserByEmailAndRoleName(String email, String roleName);

    //List<Users> loginEmail(String email, String password);
}
