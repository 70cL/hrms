package io.kodloma.hrms.business.concrete;

import io.kodloma.hrms.adapters.concrete.CloudinaryService;
import io.kodloma.hrms.business.abtracts.ResumesService;
import io.kodloma.hrms.core.DataResult;
import io.kodloma.hrms.core.Result;
import io.kodloma.hrms.core.SuccessDataResult;
import io.kodloma.hrms.dataAccessLayer.abstracts.ResumesDao;
import io.kodloma.hrms.entities.concrete.Resumes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class ResumesManager implements ResumesService {

    private ResumesDao resumesDao;
    private CloudinaryService cloudinaryService;

    @Autowired
    public ResumesManager(ResumesDao resumesDao, CloudinaryService cloudinaryService){
        this.resumesDao = resumesDao;
        this.cloudinaryService = cloudinaryService;
    }

    @Override
    public DataResult<List<Resumes>> getAll() {
        return new SuccessDataResult<>("Özgeçmişler", resumesDao.findAll());
    }

    @Override
    public Result saveImage(MultipartFile multipartFile, int resumeId) throws IOException {
        String url = cloudinaryService.url(multipartFile);

        Optional<Resumes> cv = resumesDao.findById(resumeId);
        Resumes currentCv = cv.get();
        currentCv.setPhoto(url);
        resumesDao.save(currentCv);

        return new SuccessDataResult<Resumes>("Resim eklendi", currentCv);
    }
}
