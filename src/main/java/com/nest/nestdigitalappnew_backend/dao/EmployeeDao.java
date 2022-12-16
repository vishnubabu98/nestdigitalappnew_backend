package com.nest.nestdigitalappnew_backend.dao;

import com.nest.nestdigitalappnew_backend.model.Employees;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeDao extends CrudRepository<Employees,Integer> {

    @Query(value="SELECT `id`, `address`, `email`, `empcode`, `empname`, `mobno`, `password`, `username` FROM `employees` WHERE `empcode`= :empcode",nativeQuery = true)
    List<Employees> searchEmployee(@Param("empcode")Integer empcode);

    @Modifying
    @Transactional
    @Query(value="DELETE FROM `employees` WHERE `id` = :id",nativeQuery = true)
    void deleteEmployee(@Param("id")Integer id);

    @Modifying
    @Transactional
    @Query(value="UPDATE `employees` SET `address`= :address,`email`= :email,`empname`= :empname,`mobno`= :mobno,`username`= :username WHERE `id` = :id",nativeQuery = true)
    void updateEmployee(@Param("id")Integer id,@Param("address")String address,@Param("email")String email,@Param("empname")String empname,@Param("mobno")String mobno,@Param("username")String username);

    @Query(value="SELECT `id`, `address`, `email`, `empcode`, `empname`, `mobno`, `password`, `username` FROM `employees` WHERE `email`= :email AND `password`= :password",nativeQuery = true)
    List<Employees>employeeAuth(@Param("email")String email,@Param("password")String password);

    @Query(value="SELECT `id`, `address`, `email`, `empcode`, `empname`, `mobno`, `password`, `username` FROM `employees` WHERE `id` = :id",nativeQuery = true)
    List<Employees>getEmpProfile(@Param("id")Integer id);
}
