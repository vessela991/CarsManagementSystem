package com.fmi_plovdiv.CarManagementApplication.repository;

import com.fmi_plovdiv.CarManagementApplication.model.Car;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends CrudRepository<Car, Long> {

}
