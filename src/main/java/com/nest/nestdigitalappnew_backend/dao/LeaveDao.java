package com.nest.nestdigitalappnew_backend.dao;

import com.nest.nestdigitalappnew_backend.model.LeaveClass;
import org.springframework.data.repository.CrudRepository;

public interface LeaveDao extends CrudRepository<LeaveClass,Integer> {
}
