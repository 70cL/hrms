package io.kodloma.hrms.controller;

import io.kodloma.hrms.business.abtracts.CandidatesService;
import io.kodloma.hrms.core.DataResult;
import io.kodloma.hrms.core.SuccessDataResult;
import io.kodloma.hrms.entities.concrete.Candidates;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/candidates")
@CrossOrigin
public class CandidatesController {

    private final CandidatesService candidatesService;

    @Autowired
    public CandidatesController(CandidatesService candidatesService)
    {
        this.candidatesService = candidatesService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<DataResult<List<Candidates>>> getAll(){
        return candidatesService.getAll();
    }

    @PostMapping("/add")
    public ResponseEntity<DataResult<Candidates>> add(@Valid @RequestBody Candidates candidates){
        return candidatesService.add(candidates);
    }
}
