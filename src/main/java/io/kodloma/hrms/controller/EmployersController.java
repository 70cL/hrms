package io.kodloma.hrms.controller;

import io.kodloma.hrms.business.abtracts.EmployeesService;
import io.kodloma.hrms.business.abtracts.EmployersService;
import io.kodloma.hrms.business.abtracts.JobPositionsService;
import io.kodloma.hrms.core.DataResult;
import io.kodloma.hrms.entities.concrete.Employees;
import io.kodloma.hrms.entities.concrete.Employers;
import io.kodloma.hrms.entities.concrete.JobPositions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/employers")
public class EmployersController {

    private EmployersService employersService;

    @Autowired
    public EmployersController(EmployersService employersService)
    {
        this.employersService = employersService;
    }

    @GetMapping("/getall")
    public DataResult<List<Employers>> getAll(){
        return employersService.getAll();
    }
}
