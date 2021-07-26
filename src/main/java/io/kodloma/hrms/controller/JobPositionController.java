package io.kodloma.hrms.controller;

import io.kodloma.hrms.business.abtracts.JobPositionsService;
import io.kodloma.hrms.core.DataResult;
import io.kodloma.hrms.core.Result;
import io.kodloma.hrms.entities.concrete.JobPositions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/job")
@CrossOrigin
public class JobPositionController {

    private JobPositionsService jobPositionsService;

    @Autowired
    public JobPositionController(JobPositionsService jobPositionsService)
    {
        this.jobPositionsService = jobPositionsService;
    }

    @GetMapping("/getAll")
    public DataResult<List<JobPositions>> getAll(){
        return jobPositionsService.getAll();
    }

    @GetMapping("/getById")
    public JobPositions getById(@RequestParam(value = "id", required = false, defaultValue = "1")String id)
    {
        return jobPositionsService.getById(Integer.parseInt(id));
    }

    @PostMapping("/add")
    public Result addJobPosition(@Valid @RequestBody JobPositions jobPosition){
        return jobPositionsService.addJob(jobPosition);
    }
}
