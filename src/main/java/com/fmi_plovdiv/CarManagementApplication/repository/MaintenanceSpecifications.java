package com.fmi_plovdiv.CarManagementApplication.repository;

import com.fmi_plovdiv.CarManagementApplication.model.Maintenance;
import org.springframework.data.jpa.domain.Specification;

public class MaintenanceSpecifications {
    public static Specification<Maintenance> hasCarId(Long carId) {
        return (root, _, criteriaBuilder) ->
                carId != null ? criteriaBuilder.equal(root.get("carId"), carId) : criteriaBuilder.conjunction();
    }

    public static Specification<Maintenance> hasGarageId(Long garageId) {
        return (root, _, criteriaBuilder) ->
                garageId != null ? criteriaBuilder.equal(root.get("garageId"), garageId) : criteriaBuilder.conjunction();
    }
}
