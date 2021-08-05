package io.kodloma.hrms.business.abtracts;

import io.kodloma.hrms.core.DataResult;
import io.kodloma.hrms.core.Result;
import io.kodloma.hrms.entities.concrete.Employers;
import io.kodloma.hrms.entities.concrete.JobPositions;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface EmployersService {
    DataResult<List<Employers>> getAll();
    Employers getByID(int id);
    Result add(Employers employers);
    Result savePhoto(MultipartFile multipartFile, int employersId);
}
