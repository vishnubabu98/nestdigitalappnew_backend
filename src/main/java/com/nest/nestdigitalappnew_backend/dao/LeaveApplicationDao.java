package com.nest.nestdigitalappnew_backend.dao;

import com.nest.nestdigitalappnew_backend.model.LeaveApplication;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LeaveApplicationDao extends CrudRepository<LeaveApplication,Integer> {

    @Query(value="SELECT `id`, `empid`, `end_date`, `leave_type`, `no_of_days`, `start_date`, `status` FROM `leaveapplication` WHERE `empid`= :empid",nativeQuery = true)
    List<LeaveApplication>employeeViewStatus(@Param("empid")Integer empid);

    @Modifying
    @Transactional
    @Query(value = "UPDATE `leaveapplication` SET `status`= :status WHERE `empid` = :empid",nativeQuery = true)
    void updateLeaveApplication(@Param("empid") Integer empid , @Param("status") Integer status);


}
