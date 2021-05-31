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

    @GetMapping("/isactive")
    public DataResult<List<JobAdvertisements>> findByActive(@RequestParam boolean status){
        return jobAdvertisementService.findByActive(status);
    }

    @GetMapping("/isActive/order")
    public DataResult<List<JobAdvertisements>> findByActiveOrderByApplicationDeadline(@RequestParam boolean status){
        return jobAdvertisementService.findByActiveOrderByApplicationDeadline(status);
    }

    @GetMapping("/get/CompanyName")
    public DataResult<List<JobAdvertisements>> findByActiveAndEmployers_CompanyName(@RequestParam boolean status,@RequestParam String companyName){
        return jobAdvertisementService.findByActiveAndEmployers_CompanyName(status, companyName);
    }
}