package io.kodloma.hrms.business.concrete;

import io.kodloma.hrms.business.abtracts.JobPositionsService;
import io.kodloma.hrms.core.DataResult;
import io.kodloma.hrms.core.ErrorDataResult;
import io.kodloma.hrms.core.Result;
import io.kodloma.hrms.core.SuccessDataResult;
import io.kodloma.hrms.dataAccessLayer.abstracts.JobPositionDao;
import io.kodloma.hrms.entities.concrete.JobPositions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JobPositionsManager implements JobPositionsService {

    private JobPositionDao jobPositionDao;

    @Autowired
    public JobPositionsManager(JobPositionDao jobPositionDao){
        this.jobPositionDao = jobPositionDao;
    }

    @Override
    public DataResult<List<JobPositions>> getAll() {
        return new SuccessDataResult<>("Başarılı",jobPositionDao.findAll());
    }

    @Override
    public JobPositions getByID(int id) {
        return jobPositionDao.findById(id).get();
    }

    @Override
    public Result addJob(JobPositions jobPositions) {
        return IsDuplicate(jobPositions) ? new ErrorDataResult<>("Pozisyon mevcut, kaydedilemedi.")
                : new SuccessDataResult<>("Kaydedildi", jobPositions);
    }

    private boolean IsDuplicate(JobPositions jobPositions){
        if(jobPositionDao.findByTitle(jobPositions.getTitle()) == null)
        {
            jobPositionDao.save(jobPositions);
            return false;
        }

        return true;
    }
}
