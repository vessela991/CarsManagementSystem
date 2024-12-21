package com.fmi_plovdiv.CarManagementApplication.repository;

import com.fmi_plovdiv.CarManagementApplication.model.Maintenance;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaintenanceRepository extends CrudRepository<Maintenance, Long> {
}
