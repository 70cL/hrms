package io.kodloma.hrms.controller;

import io.kodloma.hrms.business.abtracts.ResumesService;
import io.kodloma.hrms.core.DataResult;
import io.kodloma.hrms.core.Result;
import io.kodloma.hrms.entities.concrete.Resumes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.xml.crypto.Data;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("api/resume")
public class ResumesController {

    private ResumesService resumesService;

    @Autowired
    public ResumesController(ResumesService resumesService){
        this.resumesService = resumesService;
    }

    @GetMapping("/getAll")
    public DataResult<List<Resumes>> getAll(){
        return resumesService.getAll();
    }

    @PutMapping("/uploadPhoto")
    public Result uploadPhoto(@RequestParam(value = "file") MultipartFile multipartFile, @RequestParam(value = "id") String resumeId) throws IOException {
        return resumesService.saveImage(multipartFile, Integer.parseInt(resumeId));
    }
}
