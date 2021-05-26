package io.kodloma.hrms.business.abtracts;

import io.kodloma.hrms.core.DataResult;
import io.kodloma.hrms.entities.concrete.Candidates;

import java.util.List;

public interface CandidatesService {
    DataResult<List<Candidates>> getAll();
}
