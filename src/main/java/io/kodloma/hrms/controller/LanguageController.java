package io.kodloma.hrms.controller;

import io.kodloma.hrms.business.abtracts.LanguagesService;
import io.kodloma.hrms.core.DataResult;
import io.kodloma.hrms.core.Result;
import io.kodloma.hrms.core.SuccessDataResult;
import io.kodloma.hrms.entities.concrete.Languages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.xml.crypto.Data;
import java.util.List;

@RestController
@RequestMapping("/api/lang")
public class LanguageController {

    private LanguagesService languagesService;

    @Autowired
    public LanguageController(LanguagesService languagesService){
        this.languagesService = languagesService;
    }

    @GetMapping("/getAll")
    public DataResult<List<Languages>> getAll(){
        return languagesService.getAll();
    }

    @PostMapping("/add")
    public Result addLang(@RequestBody Languages languages){
        return languagesService.addLanguage(languages);
    }

    @GetMapping("/find")
    public DataResult<List<Languages>> findByName(@RequestParam(value = "language", defaultValue = "English") String language){
        return languagesService.finByName(language);
    }
}
