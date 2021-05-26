package io.kodloma.hrms.business.abtracts;

import io.kodloma.hrms.core.DataResult;
import io.kodloma.hrms.entities.concrete.Employees;

import java.util.List;

public interface EmployeesService {
    DataResult<List<Employees>> getAll();}
