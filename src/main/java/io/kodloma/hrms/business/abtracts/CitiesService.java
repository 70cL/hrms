package io.kodloma.hrms.business.abtracts;

import io.kodloma.hrms.core.DataResult;
import io.kodloma.hrms.entities.concrete.Cities;

import java.util.List;

public interface CitiesService {
    DataResult<List<Cities>> getAll();
}
