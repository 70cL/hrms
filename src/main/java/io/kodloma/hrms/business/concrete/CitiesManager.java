package io.kodloma.hrms.business.concrete;

import io.kodloma.hrms.business.abtracts.CitiesService;
import io.kodloma.hrms.core.DataResult;
import io.kodloma.hrms.core.ErrorDataResult;
import io.kodloma.hrms.core.SuccessDataResult;
import io.kodloma.hrms.dataAccessLayer.abstracts.CitiesDao;
import io.kodloma.hrms.entities.concrete.Cities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CitiesManager implements CitiesService {

    private CitiesDao citiesDao;

    @Autowired
    public CitiesManager(CitiesDao citiesDao){
        this.citiesDao = citiesDao;
    }

    @Override
    public DataResult<List<Cities>> getAll() {
        return citiesDao.findAll().isEmpty() ? new ErrorDataResult<>("Şehir bulunamadı")
                : new SuccessDataResult<>("Şehirler listelendi", citiesDao.findAll());
    }
}
