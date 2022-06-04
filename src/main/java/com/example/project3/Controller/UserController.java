package com.example.project3.Controller;

import com.example.project3.DTO.API;
import com.example.project3.Model.User;
import com.example.project3.Service.BookService;
import com.example.project3.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/user")
public class UserController {

    private final UserService userService;


    Logger logger = LoggerFactory.getLogger(UserController.class);


    @GetMapping("/getUsers")
    public ResponseEntity<List<User>> getUsers(){
        logger.info("Get Users");
        return ResponseEntity.status(200).body(userService.getUsers());
    }

    @PostMapping("/addUser")
    public ResponseEntity<API> addUser(@Valid @RequestBody User user) throws IllegalAccessException{
        userService.addUser(user);
        logger.info("Add Users");
        return ResponseEntity.status(201).body(new API("User is added !",201));
    }

}
