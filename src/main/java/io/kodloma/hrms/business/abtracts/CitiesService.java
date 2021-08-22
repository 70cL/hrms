package io.kodloma.hrms.business.abtracts;

import io.kodloma.hrms.core.DataResult;
import io.kodloma.hrms.entities.concrete.Cities;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CitiesService {
    ResponseEntity<DataResult<List<Cities>>> getAll();
}
