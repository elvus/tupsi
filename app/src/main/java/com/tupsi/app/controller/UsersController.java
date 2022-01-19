package com.tupsi.app.controller;

import java.util.ArrayList;
import java.util.List;

import com.tupsi.app.model.Users;
import com.tupsi.app.repository.UsersRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class UsersController {

    @Autowired
    UsersRepository usersRepository;

    @GetMapping("/users")
    public ResponseEntity<List<Users>> getAllUsers(@RequestParam(required = false) String cod_user){
        try{
            List<Users> users = new ArrayList<Users>();

            if(cod_user == null){
                usersRepository.findAll().forEach(users::add);
            }else{
                usersRepository.findByCodUser(cod_user).forEach(users::add);
            }
            return new ResponseEntity<>(users, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
