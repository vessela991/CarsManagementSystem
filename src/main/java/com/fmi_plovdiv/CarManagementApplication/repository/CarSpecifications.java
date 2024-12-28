package com.fmi_plovdiv.CarManagementApplication.repository;

import com.fmi_plovdiv.CarManagementApplication.model.Car;
import org.springframework.data.jpa.domain.Specification;

public class CarSpecifications {

    public static Specification<Car> hasCarMake(String carMake) {
        return (root, _, criteriaBuilder) ->
                carMake != null ? criteriaBuilder.like(root.get("make"), carMake + "%") : criteriaBuilder.conjunction();
    }

    public static Specification<Car> hasGarageId(Long garageId) {
        return (root, _, criteriaBuilder) -> {
            if (garageId == null) {
                return criteriaBuilder.conjunction();
            }
            return criteriaBuilder.isMember(garageId, root.get("garageIds"));
        };
    }

    public static Specification<Car> hasFromYear(Integer fromYear) {
        return (root, _, criteriaBuilder) ->
                fromYear != null ? criteriaBuilder.greaterThanOrEqualTo(root.get("productionYear"), fromYear) : criteriaBuilder.conjunction();
    }

    public static Specification<Car> hasToYear(Integer toYear) {
        return (root, _, criteriaBuilder) ->
                toYear != null ? criteriaBuilder.lessThanOrEqualTo(root.get("productionYear"), toYear) : criteriaBuilder.conjunction();
    }
}
