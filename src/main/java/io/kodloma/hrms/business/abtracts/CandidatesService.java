package io.kodloma.hrms.business.abtracts;

import io.kodloma.hrms.core.DataResult;
import io.kodloma.hrms.core.Result;
import io.kodloma.hrms.core.SuccessDataResult;
import io.kodloma.hrms.entities.concrete.Candidates;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CandidatesService {
    ResponseEntity<DataResult<List<Candidates>>> getAll();
    ResponseEntity<DataResult<Candidates>> add(Candidates candidates);
}
