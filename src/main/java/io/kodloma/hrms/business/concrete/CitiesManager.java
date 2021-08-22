package io.kodloma.hrms.business.concrete;

import io.kodloma.hrms.business.abtracts.CitiesService;
import io.kodloma.hrms.core.DataResult;
import io.kodloma.hrms.core.ErrorDataResult;
import io.kodloma.hrms.core.SuccessDataResult;
import io.kodloma.hrms.dataAccessLayer.abstracts.CitiesDao;
import io.kodloma.hrms.entities.concrete.Cities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<DataResult<List<Cities>>> getAll() {
        return citiesDao.findAll().isEmpty() ? new ResponseEntity<>(new ErrorDataResult<>("Şehir bulunamadı"), HttpStatus.NOT_FOUND)
                 :new ResponseEntity<>(new SuccessDataResult<>("Şehirler listelendi", citiesDao.findAll()), HttpStatus.NOT_FOUND);
    }
}
