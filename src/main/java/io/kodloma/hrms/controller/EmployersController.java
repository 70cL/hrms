package io.kodloma.hrms.controller;

import com.sun.istack.NotNull;
import io.kodloma.hrms.business.abtracts.EmployeesService;
import io.kodloma.hrms.business.abtracts.EmployersService;
import io.kodloma.hrms.business.abtracts.JobPositionsService;
import io.kodloma.hrms.core.DataResult;
import io.kodloma.hrms.core.ErrorDataResult;
import io.kodloma.hrms.core.Result;
import io.kodloma.hrms.entities.concrete.Employees;
import io.kodloma.hrms.entities.concrete.Employers;
import io.kodloma.hrms.entities.concrete.JobPositions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/employers")
@CrossOrigin
public class EmployersController {

    private EmployersService employersService;

    @Autowired
    public EmployersController(EmployersService employersService)
    {
        this.employersService = employersService;
    }

    @GetMapping("/getAll")
    public DataResult<List<Employers>> getAll(){
        return employersService.getAll();
    }

    @PostMapping("/add")
    public Result addEmployer(@Valid @RequestBody Employers employers){
       return employersService.add(employers);
    }

    @PutMapping("/uploadPhoto")
    public Result uploadPhoto(@RequestParam(value = "file") MultipartFile multipartFile, @RequestParam(value = "id") String employerId){
        return employersService.savePhoto(multipartFile, Integer.parseInt(employerId));
    }
}
