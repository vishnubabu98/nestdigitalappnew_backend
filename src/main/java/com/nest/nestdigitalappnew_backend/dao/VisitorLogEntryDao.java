package com.nest.nestdigitalappnew_backend.dao;

import com.nest.nestdigitalappnew_backend.model.VisitorLogEntry;
import org.springframework.data.repository.CrudRepository;

public interface VisitorLogEntryDao extends CrudRepository<VisitorLogEntry,Integer> {
}
