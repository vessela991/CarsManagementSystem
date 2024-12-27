package com.fmi_plovdiv.CarManagementApplication.repository;

import com.fmi_plovdiv.CarManagementApplication.model.Maintenance;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MaintenanceRepository extends CrudRepository<Maintenance, Long> {
    @Query("SELECT m from Maintenance m where m.garageId = :garageId and m.scheduledDate = :scheduledDate")
    List<Maintenance> findByGarageIdAndScheduleDate(@Param("garageId") Long garageId, @Param("scheduledDate") String scheduledDate);
    @Query("SELECT m from Maintenance m where m.garageId = :garageId")
    List<Maintenance> findByGarageId(@Param("garageId") Long garageId);
}
