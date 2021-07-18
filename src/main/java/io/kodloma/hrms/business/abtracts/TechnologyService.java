package io.kodloma.hrms.business.abtracts;

import io.kodloma.hrms.core.DataResult;
import io.kodloma.hrms.core.Result;
import io.kodloma.hrms.entities.concrete.Technologies;

import java.util.List;

public interface TechnologyService {
    DataResult<List<Technologies>> getAll();
    Result addTechnology(Technologies technologies);
}
