package io.kodloma.hrms.business.abtracts;

import io.kodloma.hrms.core.DataResult;
import io.kodloma.hrms.entities.concrete.Employers;

import java.util.List;

public interface EmployersService {
    DataResult<List<Employers>> getAll();
}
