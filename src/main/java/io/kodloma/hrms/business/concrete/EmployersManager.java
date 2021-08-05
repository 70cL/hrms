package io.kodloma.hrms.business.concrete;

import io.kodloma.hrms.adapters.concrete.CloudinaryService;
import io.kodloma.hrms.business.abtracts.EmployersService;
import io.kodloma.hrms.core.DataResult;
import io.kodloma.hrms.core.ErrorDataResult;
import io.kodloma.hrms.core.Result;
import io.kodloma.hrms.core.SuccessDataResult;
import io.kodloma.hrms.dataAccessLayer.abstracts.EmployersDao;
import io.kodloma.hrms.entities.concrete.Employers;
import io.kodloma.hrms.entities.concrete.Resumes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class EmployersManager implements EmployersService {

    private EmployersDao employersDao;
    private CloudinaryService cloudinaryService;

    @Autowired
    public EmployersManager(EmployersDao employersDao, CloudinaryService cloudinaryService){
        this.employersDao = employersDao;
        this.cloudinaryService = cloudinaryService;
    }

    @Override
    public DataResult<List<Employers>> getAll() {
        return new SuccessDataResult<>("Başarılı", employersDao.findAll());
    }

    @Override
    public Employers getByID(int id) {
        return employersDao.findById(id).get();
    }

    @Override
    public Result add(Employers employers) {
        if(IsMatch(employers) && !IsDuplicate(employers)) {
            employersDao.save(employers);
            return new SuccessDataResult<>("başarı ile kaydedildi" ,employers);
        }

        return new ErrorDataResult<>("problem", employers);
    }

    @Override
    public Result savePhoto(MultipartFile multipartFile, int employersId) {
        Employers currentEmployer;

        try {
            String url = cloudinaryService.url(multipartFile);
            Optional<Employers> cv = employersDao.findById(employersId);
            currentEmployer = cv.orElseThrow();
            currentEmployer.setCompanyPhoto(url);
            employersDao.save(currentEmployer);
        }
        catch (NoSuchElementException | IOException Exception)
        {
            return new ErrorDataResult<>("Resim eklenemedi");
        }

        return new SuccessDataResult<>("Resim eklendi", currentEmployer);
    }


    private boolean IsDuplicate(Employers employers){
        return employersDao.findByMail(employers.getMail()) != null;
    }

    private boolean IsMatch(Employers employers){
        String [] mail = employers.getMail().split("[@]");

        mail[mail.length - 1] = "www." + mail[mail.length - 1];

        return employers.getWeb_address().equals(mail[mail.length - 1]);
    }
}
