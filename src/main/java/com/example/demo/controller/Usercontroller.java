package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Usermodel;
import com.example.demo.service.Userservice;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
public class Usercontroller {
    @Autowired
    Userservice userservice;

    @GetMapping("/")
    public String hello() {
        return "Dashboard...";
    }

    @GetMapping("/getUser")
     public List<Usermodel> getUsersdata() throws ClassNotFoundException{
        return userservice.sendToController();
     }

     @PostMapping("/createUser")
     public String postMethodName(@RequestBody Usermodel usermodel) {         
        return userservice.getClientData(usermodel);
     }

      @DeleteMapping("/deleteUser/{id}")
      public String deleteUserData(@PathVariable String id) throws ClassNotFoundException {
          return userservice.deleteUser(id);
      }

      @PutMapping("/updateUser/{id}")
      public String putMethodName(@PathVariable String id, @RequestBody Usermodel usermodel) {
            userservice.updateUserdata(usermodel, id);          
            return "update succesfully";
      }
}
