package io.kodloma.hrms.business.abtracts;

import io.kodloma.hrms.core.DataResult;
import io.kodloma.hrms.core.Result;
import io.kodloma.hrms.entities.concrete.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {
    DataResult<List<User>> getAll();
    Result save(User user);
}
