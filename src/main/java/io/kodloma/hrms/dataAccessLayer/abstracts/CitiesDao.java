package io.kodloma.hrms.dataAccessLayer.abstracts;

import io.kodloma.hrms.entities.concrete.Cities;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CitiesDao extends JpaRepository<Cities, Integer> {
}
