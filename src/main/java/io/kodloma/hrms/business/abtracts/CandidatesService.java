package io.kodloma.hrms.business.abtracts;

import io.kodloma.hrms.core.DataResult;
import io.kodloma.hrms.core.Result;
import io.kodloma.hrms.entities.concrete.Candidates;
import io.kodloma.hrms.entities.concrete.Employers;

import java.util.List;

public interface CandidatesService {
    DataResult<List<Candidates>> getAll();
    Result add(Candidates candidates);
}
