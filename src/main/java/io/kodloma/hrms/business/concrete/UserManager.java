package io.kodloma.hrms.business.concrete;

import io.kodloma.hrms.business.abtracts.UserService;
import io.kodloma.hrms.core.DataResult;
import io.kodloma.hrms.core.SuccessDataResult;
import io.kodloma.hrms.dataAccessLayer.abstracts.UserDao;
import io.kodloma.hrms.entities.concrete.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
