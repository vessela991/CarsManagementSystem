package com.fmi_plovdiv.CarManagementApplication.repository;

import com.fmi_plovdiv.CarManagementApplication.model.Car;
import org.springframework.data.jpa.domain.Specification;

public class CarSpecifications {

    public static Specification<Car> hasCarMake(String carMake) {
        return (root, _, criteriaBuilder) ->
                carMake != null ? criteriaBuilder.like(root.get("make"), carMake + "%") : criteriaBuilder.conjunction();
    }

    public static Specification<Car> hasGarageId(Long garageId) {
        return (root, _, criteriaBuilder) ->
                garageId != null ? criteriaBuilder.equal(root.get("garageId"), garageId) : criteriaBuilder.conjunction();
    }
}
