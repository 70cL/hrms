package io.kodloma.hrms.controller;

import io.kodloma.hrms.business.abtracts.JobAdvertisementService;
import io.kodloma.hrms.core.DataResult;
import io.kodloma.hrms.core.Result;
import io.kodloma.hrms.entities.concrete.JobAdvertisements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobadv")
@CrossOrigin
public class JobAdvertisementController {

    JobAdvertisementService jobAdvertisementService;

    @Autowired
    public JobAdvertisementController(JobAdvertisementService jobAdvertisementService){
        this.jobAdvertisementService = jobAdvertisementService;
    }

    @GetMapping("/getAll")
    public DataResult<List<JobAdvertisements>> getAll(){
        return jobAdvertisementService.getAll();
    }

    @PostMapping("/add")
    public Result add(@RequestBody JobAdvertisements jobAdvertisements){
        return jobAdvertisementService.add(jobAdvertisements);
    }

    @GetMapping("/active")
    public DataResult<List<JobAdvertisements>> findByActive(@RequestParam boolean status){
        return jobAdvertisementService.findByActive(status);
    }

    @GetMapping("/active/order")
    public DataResult<List<JobAdvertisements>> findByActiveOrderByApplicationDeadline(@RequestParam boolean status){
        return jobAdvertisementService.findByActiveOrderByApplicationDeadline(status);
    }

    @GetMapping("/get/companyName")
    public DataResult<List<JobAdvertisements>> findByActiveAndEmployers_CompanyName(@RequestParam boolean status,@RequestParam String companyName){
        return jobAdvertisementService.findByActiveAndEmployers_CompanyName(status, companyName);
    }
}
