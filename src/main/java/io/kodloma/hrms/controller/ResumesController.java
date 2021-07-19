package io.kodloma.hrms.controller;

import io.kodloma.hrms.business.abtracts.ResumesService;
import io.kodloma.hrms.core.DataResult;
import io.kodloma.hrms.entities.concrete.Resumes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
