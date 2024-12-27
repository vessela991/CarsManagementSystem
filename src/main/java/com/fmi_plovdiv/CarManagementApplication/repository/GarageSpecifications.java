package com.fmi_plovdiv.CarManagementApplication.repository;

import com.fmi_plovdiv.CarManagementApplication.model.Garage;
import org.springframework.data.jpa.domain.Specification;

public class GarageSpecifications {

        public static Specification<Garage> hasCity(String city) {
            return (root, _, criteriaBuilder) ->
                    city != null ? criteriaBuilder.like(root.get("city"), city + "%") : criteriaBuilder.conjunction();
        }
}
