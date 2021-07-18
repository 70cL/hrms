package io.kodloma.hrms.business.concrete;

import io.kodloma.hrms.business.abtracts.TechnologyService;
import io.kodloma.hrms.core.DataResult;
import io.kodloma.hrms.core.Result;
import io.kodloma.hrms.core.SuccessDataResult;
import io.kodloma.hrms.dataAccessLayer.abstracts.TechnologyDao;
import io.kodloma.hrms.entities.concrete.Technologies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TechnologyManager implements TechnologyService {

    private TechnologyDao technologyDao;

    @Autowired
    public TechnologyManager(TechnologyDao technologyDao){
        this.technologyDao = technologyDao;
    }

    @Override
    public DataResult<List<Technologies>> getAll() {
        return new SuccessDataResult<>("Teknoloji listesi", technologyDao.findAll());
    }

    @Override
    public Result addTechnology(Technologies technologies) {
        return new SuccessDataResult<>("Kayıt edildi", technologyDao.save(technologies));
    }
}
