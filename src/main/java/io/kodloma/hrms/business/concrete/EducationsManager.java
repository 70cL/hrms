package io.kodloma.hrms.business.concrete;

import io.kodloma.hrms.business.abtracts.EducationsService;
import io.kodloma.hrms.core.DataResult;
import io.kodloma.hrms.core.SuccessDataResult;
import io.kodloma.hrms.dataAccessLayer.abstracts.EducationsDao;
import io.kodloma.hrms.entities.concrete.Educations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EducationsManager implements EducationsService {

    private EducationsDao educationsDao;

    @Autowired
    public EducationsManager(EducationsDao educationsDao){
        this.educationsDao = educationsDao;
    }

    @Override
    public DataResult<List<Educations>> getAll() {
        return new SuccessDataResult<>("Bütün eğitimler", educationsDao.findAll());
    }
}
