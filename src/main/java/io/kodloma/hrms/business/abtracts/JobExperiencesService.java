package io.kodloma.hrms.business.abtracts;

import io.kodloma.hrms.core.DataResult;
import io.kodloma.hrms.entities.concrete.JobExperiences;

import java.util.List;

public interface JobExperiencesService {
    DataResult<List<JobExperiences>> getALl();
}
