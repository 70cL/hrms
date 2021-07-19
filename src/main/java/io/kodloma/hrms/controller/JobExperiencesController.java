package io.kodloma.hrms.controller;

import io.kodloma.hrms.business.abtracts.JobExperiencesService;
import io.kodloma.hrms.core.DataResult;
import io.kodloma.hrms.entities.concrete.JobExperiences;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/jobexp")
public class JobExperiencesController {

    private JobExperiencesService jobExperiencesService;

    @Autowired
    public JobExperiencesController(JobExperiencesService jobExperiencesService){
        this.jobExperiencesService = jobExperiencesService;
    }

    @GetMapping("/getAll")
    public DataResult<List<JobExperiences>> getAll(){
        return jobExperiencesService.getALl();
    }
}
