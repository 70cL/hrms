package io.kodloma.hrms.business.concrete;

import io.kodloma.hrms.business.abtracts.JobPositionsService;
import io.kodloma.hrms.dataAccessLayer.abstracts.JobPositionDao;
import io.kodloma.hrms.entities.concrete.JobPositions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobPositionsManager implements JobPositionsService {

    private JobPositionDao jobPositionDao;

    @Autowired
    public JobPositionsManager(JobPositionDao jobPositionDao){
        this.jobPositionDao = jobPositionDao;
    }

    @Override
    public List<JobPositions> getAll() {
        return jobPositionDao.findAll();
    }

    @Override
    public JobPositions getByID(int id) {
        return jobPositionDao.findById(id).get();
    }


}
