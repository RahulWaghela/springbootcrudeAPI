package com.example.demo.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.stereotype.Service;
import com.example.demo.model.Usermodel;
import com.example.demo.respository.Userrepository;

@Service
public class Userservice {
    @Autowired
    Userrepository userrepository;
    public List<Usermodel> sendToController() throws ClassNotFoundException{
       return userrepository.getUserData();
    }

    public String getClientData(Usermodel usermodel) {
        userrepository.createNewUser(usermodel);
        return "user created...";
    }

    public String deleteUser(String id) throws ClassNotFoundException {
         userrepository.deleteUser(id);
        return "user deleted sucessfully...";
    }

    public void updateUserdata(Usermodel usermodel, String id) {
       userrepository.updateUserInfo(id, usermodel);
    }

   
}