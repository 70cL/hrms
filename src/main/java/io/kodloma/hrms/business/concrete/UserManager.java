package io.kodloma.hrms.business.concrete;

import io.kodloma.hrms.business.abtracts.UserService;
import io.kodloma.hrms.core.DataResult;
import io.kodloma.hrms.core.ErrorDataResult;
import io.kodloma.hrms.core.Result;
import io.kodloma.hrms.core.SuccessDataResult;
import io.kodloma.hrms.dataAccessLayer.abstracts.UserDao;
import io.kodloma.hrms.entities.concrete.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.persistence.EntityManager;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserManager implements UserService {

    private UserDao userDao;

    @Autowired
    public UserManager(UserDao userDao){
        this.userDao = userDao;
    }

    @Override
    public DataResult<List<User>> getAll() {
        return new SuccessDataResult<>("Başarılı", userDao.findAll());
    }

    @Override
    public Result save(User user) {
        return new SuccessDataResult("başarılı", userDao.save(user));
    }

}
