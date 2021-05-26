package io.kodloma.hrms.business.concrete;

import io.kodloma.hrms.business.abtracts.EmployeesService;
import io.kodloma.hrms.core.DataResult;
import io.kodloma.hrms.core.SuccessDataResult;
import io.kodloma.hrms.dataAccessLayer.abstracts.EmployeesDao;
import io.kodloma.hrms.entities.concrete.Employees;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeesManager implements EmployeesService {

    private EmployeesDao employeesDao;

    @Autowired
    public EmployeesManager(EmployeesDao employeesDao){
        this.employeesDao = employeesDao;
    }


    @Override
    public DataResult<List<Employees>> getAll() {
        return new SuccessDataResult<>("Başarılı", employeesDao.findAll());
    }
}
