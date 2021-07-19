package io.kodloma.hrms.business.abtracts;

import io.kodloma.hrms.core.DataResult;
import io.kodloma.hrms.entities.concrete.Resumes;

import java.util.List;

public interface ResumesService {
    DataResult<List<Resumes>> getAll();
}
