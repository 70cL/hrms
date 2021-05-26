package io.kodloma.hrms.dataAccessLayer.abstracts;

import io.kodloma.hrms.entities.concrete.Employees;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeesDao extends JpaRepository<Employees, Integer> {
}
