package io.kodloma.hrms.business.concrete;

import io.kodloma.hrms.business.abtracts.JobExperiencesService;
import io.kodloma.hrms.core.DataResult;
import io.kodloma.hrms.core.SuccessDataResult;
import io.kodloma.hrms.dataAccessLayer.abstracts.JobExperienceDao;
import io.kodloma.hrms.entities.concrete.JobExperiences;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobExperiencesManager implements JobExperiencesService {

    private JobExperienceDao jobExperienceDao;

    @Autowired
    public JobExperiencesManager(JobExperienceDao jobExperienceDao){
        this.jobExperienceDao = jobExperienceDao;
    }

    @Override
    public DataResult<List<JobExperiences>> getALl() {
        return new SuccessDataResult<>("iş tecrübeleri", jobExperienceDao.findAll());
    }
}
