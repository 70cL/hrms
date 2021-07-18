package io.kodloma.hrms.controller;

import io.kodloma.hrms.business.abtracts.EducationsService;
import io.kodloma.hrms.core.DataResult;
import io.kodloma.hrms.entities.concrete.Educations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/edu")
public class EducationsController {

    private EducationsService educationsService;

    @Autowired
    public EducationsController(EducationsService educationsService){
        this.educationsService = educationsService;
    }

    @GetMapping("/getAll")
    public DataResult<List<Educations>> getAll(){
        return educationsService.getAll();
    }
}
