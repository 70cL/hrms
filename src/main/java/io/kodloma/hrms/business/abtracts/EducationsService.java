package io.kodloma.hrms.business.abtracts;

import io.kodloma.hrms.core.DataResult;
import io.kodloma.hrms.entities.concrete.Educations;

import java.util.List;

public interface EducationsService {
    DataResult<List<Educations>> getAll();
}
