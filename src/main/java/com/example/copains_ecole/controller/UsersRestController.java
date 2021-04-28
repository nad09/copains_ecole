package com.example.copains_ecole.controller;

import com.example.copains_ecole.exceptions.MissingInformationException;
import com.example.copains_ecole.exceptions.NotFoundUserException;
import com.example.copains_ecole.exceptions.PseudoNotNullException;
import com.example.copains_ecole.model.UserBean;
import com.example.copains_ecole.model.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@RestController
public class UsersRestController {


    @Autowired
    private UserDao userDao;

    //http://localhost:8080/getUsers
    @GetMapping("/getUsers")
    public ArrayList<UserBean> getUsers() {
        System.out.println("/getUsers");
        return (ArrayList<UserBean>) userDao.findAll();
    }

    //http://localhost:8080/setUserCoord
    @PostMapping("/setUserCoord")
    public void setUserCoord(@RequestBody UserBean user) {
        System.out.println("/setUserCoord " + user.getLongitude() + " " + user.getLatitude());
        Double longitude = user.getLongitude();
        Double latitude = user.getLatitude();
        if (longitude != null && latitude != null) {
                UserBean userToUpdate = userDao.getOne(user.getId());
                userToUpdate.setLongitude(longitude);
                userToUpdate.setLatitude(latitude);
                userDao.save(userToUpdate);
        } else {
            throw new MissingInformationException();
        }
    }

    //http://localhost:8080/login
    @PostMapping("/login")
    public UserBean login(@RequestBody UserBean user) {
        System.out.println("/login " + user.getPseudo() + " " + user.getPassword());

        String pseudo = user.getPseudo();
        String password = user.getPassword();
        UserBean userToLog = userDao.findByPseudo(pseudo);

        if (userToLog != null){
            if(userToLog.getPassword().equals(password)){
                UserBean userReturn = new UserBean();
                userReturn.setId(userToLog.getId());
                return userReturn;
            } else {
                throw new NotFoundUserException();
            }
        } else {
            throw new MissingInformationException();
        }
    }
//http://localhost:8080/register
@PostMapping("/register")
public UserBean register(@RequestBody UserBean user)  {
    System.out.println("/register " + user.getPseudo() + user.getPassword());

    String pseudo = user.getPseudo();
    String password = user.getPassword();

    if (pseudo==null || pseudo.isEmpty() || password==null || password.isEmpty()){
        throw new MissingInformationException();
    } else if(userDao.findByPseudo(pseudo) != null){
        throw new PseudoNotNullException();
    } else {
        user.setGroup_users(1);
        userDao.save(user);
        UserBean response = new UserBean();
        response.setId(user.getId());

        return response;
    }
}

}

