package io.kodloma.hrms.business.abtracts;

import io.kodloma.hrms.core.DataResult;
import io.kodloma.hrms.core.Result;
import io.kodloma.hrms.entities.concrete.JobPositions;

import java.util.List;

public interface JobPositionsService {
    DataResult<List<JobPositions>> getAll();
    JobPositions getById(int id);
    Result addJob(JobPositions jobPositions);
}
