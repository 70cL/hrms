package io.kodloma.hrms.controller;

import io.kodloma.hrms.business.abtracts.CitiesService;
import io.kodloma.hrms.core.DataResult;
import io.kodloma.hrms.entities.concrete.Cities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/cities")
@CrossOrigin
public class CitiesController {

    CitiesService citiesService;

    @Autowired
    public CitiesController(CitiesService citiesService){
        this.citiesService = citiesService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<DataResult<List<Cities>>> getAll(){
        return citiesService.getAll();
    }
}
