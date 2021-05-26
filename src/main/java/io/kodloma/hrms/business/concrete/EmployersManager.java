package io.kodloma.hrms.business.concrete;

import io.kodloma.hrms.business.abtracts.EmployersService;
import io.kodloma.hrms.core.DataResult;
import io.kodloma.hrms.core.SuccessDataResult;
import io.kodloma.hrms.dataAccessLayer.abstracts.EmployersDao;
import io.kodloma.hrms.entities.concrete.Employers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployersManager implements EmployersService {

    private EmployersDao employersDao;

    @Autowired
    public EmployersManager(EmployersDao employersDao){
        this.employersDao = employersDao;
    }

    @Override
    public DataResult<List<Employers>> getAll() {
        return new SuccessDataResult<>("Başarılı", employersDao.findAll());
    }
}
