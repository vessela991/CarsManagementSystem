package com.fmi_plovdiv.CarManagementApplication.repository;

import com.fmi_plovdiv.CarManagementApplication.model.Garage;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GarageRepository extends CrudRepository<Garage, Long> {
}
