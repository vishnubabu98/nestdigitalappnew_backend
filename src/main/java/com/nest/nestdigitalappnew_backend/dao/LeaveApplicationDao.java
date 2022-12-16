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

    @Query(value="SELECT `id`, `empid`, `end_date`, `leave_type`, `no_of_days`, `start_date`, `status`, `applyingdate`, `reason`, `updated` FROM `leaveapplication` WHERE `empid` = :empid",nativeQuery = true)
    List<LeaveApplication> leaveApplicationStatus(@Param("empid") Integer empid);

    @Query(value = "SELECT `id`, `empid`, `end_date`, `leave_type`, `no_of_days`, `start_date`, `status`, `applyingdate`, `reason`, `updated` FROM `leaveapplication` WHERE `applyingdate` = :applyingdate",nativeQuery = true)
    List<LeaveApplication>adminleaveUpdate(@Param("applyingdate")String applyingdate);

    @Modifying
    @Transactional
    @Query(value = "UPDATE `leaveapplication` SET `status`= :status,`updated`= :updated WHERE `id`= :id",nativeQuery = true)
    void leaveStatusUpdate(@Param("id") Integer id, @Param("status") Integer status,@Param("updated") Integer updated);
}

