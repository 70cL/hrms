package io.kodloma.hrms.controller;

import io.kodloma.hrms.business.abtracts.JobPositionsService;
import io.kodloma.hrms.entities.concrete.JobPositions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/job")
public class JobPositionController {

    private JobPositionsService jobPositionsService;

    @Autowired
    public JobPositionController(JobPositionsService jobPositionsService)
    {
        this.jobPositionsService = jobPositionsService;
    }

    @GetMapping("/getall")
    public List<JobPositions> getAll(){
        return jobPositionsService.getAll();
    }

    @GetMapping("/getbyid")
    public JobPositions getById(@RequestParam(value = "id", required = false, defaultValue = "1")String id)
    {
        return jobPositionsService.getByID(Integer.parseInt(id));
    }

}
