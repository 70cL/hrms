package io.kodloma.hrms.controller;

import io.kodloma.hrms.business.abtracts.UserService;
import io.kodloma.hrms.core.DataResult;
import io.kodloma.hrms.core.ErrorDataResult;
import io.kodloma.hrms.entities.concrete.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/user")
@CrossOrigin
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService)
    {
        this.userService = userService;
    }

    @GetMapping("/getAll")
    public DataResult<List<User>> getAll(){
        return userService.getAll();
    }

    @PostMapping("/add")
    public ResponseEntity<?> addUser(@Valid @RequestBody User user){
        return ResponseEntity.ok(userService.save(user));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDataResult<Object> handleValidationException(MethodArgumentNotValidException exception){
        Map<String, String> errors = new HashMap<>();
        for(FieldError fieldError:exception.getBindingResult().getFieldErrors())
            errors.put(fieldError.getField(),fieldError.getDefaultMessage());


        return new ErrorDataResult<>("validasyon hataları", errors);
    }
}
