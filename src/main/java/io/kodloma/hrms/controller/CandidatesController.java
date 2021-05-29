package io.kodloma.hrms.controller;

import io.kodloma.hrms.business.abtracts.CandidatesService;
import io.kodloma.hrms.business.abtracts.EmployersService;
import io.kodloma.hrms.core.DataResult;
import io.kodloma.hrms.core.Result;
import io.kodloma.hrms.entities.concrete.Candidates;
import io.kodloma.hrms.entities.concrete.Employers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/candidates")
public class CandidatesController {

    private CandidatesService candidatesService;

    @Autowired
    public CandidatesController(CandidatesService candidatesService)
    {
        this.candidatesService = candidatesService;
    }

    @GetMapping("/getall")
    public DataResult<List<Candidates>> getAll(){
        return candidatesService.getAll();
    }

    @PostMapping("/add")
    public Result add(@Valid @RequestBody Candidates candidates){
        return candidatesService.add(candidates);
    }
}
