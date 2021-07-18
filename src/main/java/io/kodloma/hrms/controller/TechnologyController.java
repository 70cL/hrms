package io.kodloma.hrms.controller;

import io.kodloma.hrms.business.abtracts.TechnologyService;
import io.kodloma.hrms.core.DataResult;
import io.kodloma.hrms.core.Result;
import io.kodloma.hrms.entities.concrete.Technologies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tech")
public class TechnologyController {

    private TechnologyService technologyService;

    @Autowired
    public TechnologyController(TechnologyService technologyService){
        this.technologyService = technologyService;
    }

    @GetMapping("/getAll")
    public DataResult<List<Technologies>> getAll(){
        return technologyService.getAll();
    }

    @PostMapping("/add")
    public Result addTechnology(@RequestBody Technologies technologies){
        return technologyService.addTechnology(technologies);
    }
}
