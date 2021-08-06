package io.kodloma.hrms.business.concrete;

import io.kodloma.hrms.business.abtracts.JobAdvertisementService;
import io.kodloma.hrms.core.DataResult;
import io.kodloma.hrms.core.ErrorDataResult;
import io.kodloma.hrms.core.Result;
import io.kodloma.hrms.core.SuccessDataResult;
import io.kodloma.hrms.dataAccessLayer.abstracts.JobAdvertisementsDao;
import io.kodloma.hrms.entities.concrete.JobAdvertisements;
import io.kodloma.hrms.entities.dto.JobAdvertisementMapper;
import io.kodloma.hrms.entities.dto.JobAdvertisementUpdateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class JobAdvertisementManager implements JobAdvertisementService {

    JobAdvertisementsDao jobAdvertisementsDao;

    JobAdvertisementMapper jobAdvertisementMapper;

    @Autowired
    public JobAdvertisementManager(JobAdvertisementsDao jobAdvertisementsDao, JobAdvertisementMapper jobAdvertisementMapper){
        this.jobAdvertisementsDao = jobAdvertisementsDao;
        this.jobAdvertisementMapper = jobAdvertisementMapper;
    }

    @Override
    public DataResult<List<JobAdvertisements>> getAll() {
        return jobAdvertisementsDao.findAll().isEmpty() ? new ErrorDataResult<>("İlan bulunamadı")
                : new SuccessDataResult<>("İlanlar listelendi", jobAdvertisementsDao.findAll());
    }

    @Override
    public Result add(JobAdvertisementUpdateDTO jobAdvertisement) {

        JobAdvertisements jobAdvertisements = jobAdvertisementMapper.fromDto(jobAdvertisement);

        jobAdvertisementsDao.save(jobAdvertisements);

        return new SuccessDataResult<>("İlan kayıt edildi.", jobAdvertisements);
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
    public Result updateJobAd(JobAdvertisementUpdateDTO jobAdvertisementUpdateDTO, int jobAdvId) {

        Optional<JobAdvertisements> cv;

        try {
            cv = jobAdvertisementsDao.findById(jobAdvId);

            jobAdvertisementsDao.save(jobAdvertisementMapper.fromTwoOther(jobAdvertisementUpdateDTO, cv.get()));
        }
        catch (NoSuchElementException noSuchElementException)
        {
            return new ErrorDataResult<>("İlan güncellenemedi");
        }

        return new SuccessDataResult<>("İlan güncellendi", cv.get());
    }

    @Override
    public Result findById(int Id) {

        Optional<JobAdvertisements> jobAdvertisements = jobAdvertisementsDao.findById(Id);
        JobAdvertisements jobAdvById = new JobAdvertisements();

        try{
            jobAdvById = jobAdvertisements.orElseThrow();
        }
        catch (NoSuchElementException noSuchElementException){

            new ErrorDataResult<>("Kayıt bulunamadı");
        }

        return new SuccessDataResult<>("İlan No : " + Id + "bulundu", jobAdvById);
    }
}
