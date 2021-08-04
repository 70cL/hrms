package io.kodloma.hrms.business.abtracts;

import io.kodloma.hrms.core.DataResult;
import io.kodloma.hrms.core.Result;
import io.kodloma.hrms.entities.concrete.JobAdvertisements;

import java.util.List;

public interface JobAdvertisementService {
    DataResult<List<JobAdvertisements>> getAll();
    Result add(JobAdvertisements jobAdvertisement);
    DataResult<List<JobAdvertisements>> findByActive(boolean status);
    DataResult<List<JobAdvertisements>> findByActiveOrderByApplicationDeadline(boolean status);
    DataResult<List<JobAdvertisements>> findByActiveAndEmployers_CompanyName(boolean status, String companyName);
    Result updateJobAd(int id);
}
