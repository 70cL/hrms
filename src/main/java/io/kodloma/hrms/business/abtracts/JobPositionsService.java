package io.kodloma.hrms.business.abtracts;

import io.kodloma.hrms.core.DataResult;
import io.kodloma.hrms.entities.concrete.JobPositions;

import java.util.List;

public interface JobPositionsService {
    DataResult<List<JobPositions>> getAll();
    JobPositions getByID(int id);
}
