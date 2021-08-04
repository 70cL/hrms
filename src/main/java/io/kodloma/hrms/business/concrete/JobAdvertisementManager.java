package io.kodloma.hrms.business.concrete;

import io.kodloma.hrms.business.abtracts.JobAdvertisementService;
import io.kodloma.hrms.core.DataResult;
import io.kodloma.hrms.core.ErrorDataResult;
import io.kodloma.hrms.core.Result;
import io.kodloma.hrms.core.SuccessDataResult;
import io.kodloma.hrms.dataAccessLayer.abstracts.JobAdvertisementsDao;
import io.kodloma.hrms.entities.concrete.JobAdvertisements;
import io.kodloma.hrms.entities.concrete.Resumes;
import io.kodloma.hrms.entities.concrete.WorkingType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

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

    @Override
    public DataResult<List<JobAdvertisements>> findByActive(boolean status) {
        return jobAdvertisementsDao.findByActive(status).isEmpty() ?
                  new ErrorDataResult<>(status + " ilan bulunamadı", jobAdvertisementsDao.findByActive(status))
                : new SuccessDataResult<>(status + " ilanlar listelendi", jobAdvertisementsDao.findByActive(status));
    }

    @Override
    public DataResult<List<JobAdvertisements>> findByActiveOrderByApplicationDeadline(boolean status) {
        return jobAdvertisementsDao.findByActive(status).isEmpty() ?
                new ErrorDataResult<>(status + " ilan bulunamadı.",
                jobAdvertisementsDao.findByActiveOrderByApplicationDeadline(status)) :
                new SuccessDataResult<>(status + " ilanlar tarih sırasına göre listelendi.",
                jobAdvertisementsDao.findByActiveOrderByApplicationDeadline(status));
    }

    @Override
    public DataResult<List<JobAdvertisements>> findByActiveAndEmployers_CompanyName(boolean status, String companyName) {
        return jobAdvertisementsDao.findByActive(status).isEmpty() ?
                new ErrorDataResult<>(status + " ilan bulunamadı.",
                jobAdvertisementsDao.findByActiveAndEmployers_CompanyName(status, companyName)) :
                new SuccessDataResult<>(companyName + " şirketinin " + status + "iş ilanları",
                jobAdvertisementsDao.findByActiveAndEmployers_CompanyName(status, companyName));
    }

    @Override
    public Result updateJobAd(int id) {
        JobAdvertisements currentAd;

        try {
            Optional<JobAdvertisements> cv = jobAdvertisementsDao.findById(id);

            jobAdvertisementsDao.save(cv.get());

        }
        catch (NoSuchElementException noSuchElementException)
        {
            return new ErrorDataResult<JobAdvertisements>("İlan güncellenemedi");
        }

        return new SuccessDataResult<>("İlan güncellendi");
    }
}
