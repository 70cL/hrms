package io.kodloma.hrms.business.concrete;

import io.kodloma.hrms.business.abtracts.ResumesService;
import io.kodloma.hrms.core.DataResult;
import io.kodloma.hrms.core.SuccessDataResult;
import io.kodloma.hrms.dataAccessLayer.abstracts.ResumesDao;
import io.kodloma.hrms.entities.concrete.Resumes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResumesManager implements ResumesService {

    private ResumesDao resumesDao;

    @Autowired
    public ResumesManager(ResumesDao resumesDao){
        this.resumesDao = resumesDao;
    }

    @Override
    public DataResult<List<Resumes>> getAll() {
        return new SuccessDataResult<>("Özgeçmişler", resumesDao.findAll());
    }
}
