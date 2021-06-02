package io.kodloma.hrms.controller;

import io.kodloma.hrms.business.abtracts.EmployeesService;
import io.kodloma.hrms.business.abtracts.EmployersService;
import io.kodloma.hrms.core.DataResult;
import io.kodloma.hrms.entities.concrete.Employees;
import io.kodloma.hrms.entities.concrete.Employers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/employees")
public class EmployeesController {

    private EmployeesService employeesService;

    @Autowired
    public EmployeesController(EmployeesService employeesService)
    {
        this.employeesService = employeesService;
    }

    @GetMapping("/getAll")
    public DataResult<List<Employees>> getAll(){
        return employeesService.getAll();
    }
}
