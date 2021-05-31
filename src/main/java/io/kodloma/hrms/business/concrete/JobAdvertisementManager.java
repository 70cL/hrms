package io.kodloma.hrms.business.concrete;

import io.kodloma.hrms.business.abtracts.JobAdvertisementService;
import io.kodloma.hrms.core.DataResult;
import io.kodloma.hrms.core.ErrorDataResult;
import io.kodloma.hrms.core.Result;
import io.kodloma.hrms.core.SuccessDataResult;
import io.kodloma.hrms.dataAccessLayer.abstracts.JobAdvertisementsDao;
import io.kodloma.hrms.entities.concrete.JobAdvertisements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobAdvertisementManager implements JobAdvertisementService {

    JobAdvertisementsDao jobAdvertisementsDao;

    @Autowired
    public JobAdvertisementManager(JobAdvertisementsDao jobAdvertisementsDao){
        this.jobAdvertisementsDao = jobAdvertisementsDao;
    }

    @Override
    public DataResult<List<JobAdvertisements>> getAll() {
        return jobAdvertisementsDao.findAll().isEmpty() ? new ErrorDataResult<>("İlan bulunamadı")
                : new SuccessDataResult<>("İlanlar listelendi", jobAdvertisementsDao.findAll());
    }

    @Override
    public Result add(JobAdvertisements jobAdvertisement) {
        return new SuccessDataResult<>("İlan kayıt edildi.",jobAdvertisementsDao.save(jobAdvertisement));
    }
}
