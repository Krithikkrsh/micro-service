package io.ecom.practice.User.controller;

import io.ecom.practice.User.dto.UserDto;
import io.ecom.practice.User.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService service;


    @GetMapping("/hello")
    public String hello(){
        return "Hi I Am User Working Fine";
    }

   @PostMapping("/add-user")
    public ResponseEntity<?> addUser(@Valid @RequestBody UserDto user){
        service.addUser(user);
        Map<String,String> res = new HashMap<>();
        res.put("response", user.getUserName()+" successfully added!");
        res.put("status","200");
        return ResponseEntity.status(HttpStatus.OK).body(res);
   }

   @GetMapping("/get-users")
    public ResponseEntity<?> getUsers(){
        return ResponseEntity.ok(service.getUsers());
   }
}
