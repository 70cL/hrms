package io.kodloma.hrms.business.concrete;

import io.kodloma.hrms.business.abtracts.EmployersService;
import io.kodloma.hrms.core.DataResult;
import io.kodloma.hrms.core.ErrorDataResult;
import io.kodloma.hrms.core.Result;
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

    @Override
    public Employers getByID(int id) {
        return employersDao.findById(id).get();
    }

    @Override
    public Result add(Employers employers) {
        if(IsMatch(employers) && IsDuplicate(employers)) {
            employersDao.save(employers);
            return new SuccessDataResult<>("başarı ile kaydedildi");
        }

        return new ErrorDataResult<>("problem", employers);
    }

    private boolean IsDuplicate(Employers employers){
        return employersDao.findByMail(employers.getMail()) != null;
    }

    private boolean IsMatch(Employers employers){
        String [] mail = employers.getWeb_adress().split("[@]");

        return employers.getWeb_adress().equals(mail[mail.length - 1]);
    }
}
