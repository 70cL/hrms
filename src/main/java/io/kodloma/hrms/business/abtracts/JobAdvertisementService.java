package io.kodloma.hrms.business.abtracts;

import io.kodloma.hrms.core.DataResult;
import io.kodloma.hrms.core.Result;
import io.kodloma.hrms.entities.concrete.JobAdvertisements;

import java.util.List;

public interface JobAdvertisementService {
    DataResult<List<JobAdvertisements>> getAll();
    Result add(JobAdvertisements jobAdvertisement);
}
