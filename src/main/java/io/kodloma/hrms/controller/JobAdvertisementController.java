package io.kodloma.hrms.controller;

import io.kodloma.hrms.business.abtracts.JobAdvertisementService;
import io.kodloma.hrms.core.DataResult;
import io.kodloma.hrms.core.Result;
import io.kodloma.hrms.entities.concrete.JobAdvertisements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/jobadv")
public class JobAdvertisementController {

    JobAdvertisementService jobAdvertisementService;

    @Autowired
    public JobAdvertisementController(JobAdvertisementService jobAdvertisementService){
        this.jobAdvertisementService = jobAdvertisementService;
    }

    @GetMapping("/getall")
    public DataResult<List<JobAdvertisements>> getAll(){
        return jobAdvertisementService.getAll();
    }

    @PostMapping("/add")
    public Result add(@Valid @RequestBody JobAdvertisements jobAdvertisements){
        return jobAdvertisementService.add(jobAdvertisements);
    }
}
