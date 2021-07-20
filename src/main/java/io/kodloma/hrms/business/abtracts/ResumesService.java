package io.kodloma.hrms.business.abtracts;

import io.kodloma.hrms.core.DataResult;
import io.kodloma.hrms.core.Result;
import io.kodloma.hrms.entities.concrete.Resumes;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface ResumesService {
    DataResult<List<Resumes>> getAll();
    Result saveImage(MultipartFile multipartFile, int resumeId) throws IOException;
}
