package com.nest.nestdigitalappnew_backend.dao;

import com.nest.nestdigitalappnew_backend.model.Security;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SecurityDao extends CrudRepository<Security,Integer> {

    @Query(value="SELECT `id`, `address`, `mobileno`, `password`, `securitycode`, `sname`, `username` FROM `security` WHERE `securitycode`= :securitycode",nativeQuery = true)
    List<Security>addSecurity(@Param("securitycode")Integer securitycode);

    @Modifying
    @Transactional
    @Query(value="DELETE FROM `security` WHERE `id`= :id",nativeQuery = true)
    void deleteSecurity(@Param("id")Integer id);


    @Modifying
    @Transactional
    @Query(value="UPDATE `security` SET `address`= :address,`mobileno`= :mobileno,`sname`= :sname,`username`= :username WHERE `id` = :id",nativeQuery = true)
    void updateSecurity(@Param("id")Integer id,@Param("address")String address,@Param("mobileno")String mobileno,@Param("sname")String sname,@Param("username")String username);

    @Query(value ="SELECT `id`, `address`, `mobileno`, `password`, `securitycode`, `sname`, `username` FROM `security` WHERE `username` = :username AND `password` =:password",nativeQuery = true)
    List<Security>securityAuth(@Param("username")String email,@Param("password")String password);

    @Query(value = "SELECT `id`, `address`, `mobileno`, `password`, `securitycode`, `sname`, `username` FROM `security` WHERE `id`= :id",nativeQuery = true)
    List<Security>getSecurityProfile(@Param("id")Integer id);
}
