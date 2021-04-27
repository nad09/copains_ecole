package com.example.copains_ecole.controller;

import com.example.copains_ecole.model.UserBean;
import com.example.copains_ecole.model.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Optional;


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
            try {
                UserBean userToUpdate = userDao.getOne(user.getId());
                userToUpdate.setLongitude(longitude);
                userToUpdate.setLatitude(latitude);
                userDao.save(userToUpdate);
            } catch (Exception e){
                e.printStackTrace();
            }
        } else{
            System.out.println("loongitude et latitude manquantes");
        }
    }

    //http://localhost:8080/login
    @PostMapping("/login")
    public Long login(@RequestBody UserBean user) {
        System.out.println("/login " + user.getPseudo() + " " + user.getPassword());
        ArrayList<UserBean> users = getUsers();
        String pseudo = user.getPseudo();
        String password = user.getPassword();
        Long userId = null;

        if (pseudo != null && password != null) {
            try {
                for (UserBean userBean : users) {
                    if (pseudo.equals(userBean.getPseudo()) && password.equals(userBean.getPassword())) {
                        System.out.println("True");
                        userId = userBean.getId();
                    } else {
                        System.out.println("Merci de vous enregistrer");
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("pseudo ou password manquant");
        }
        System.out.println(userId);
        return userId;
    }

    //http://localhost:8080/register
    @PostMapping("/register")
    public Long register(@RequestBody UserBean user) {
        String pseudo = user.getPseudo();
        String password = user.getPassword();
        Long userId = null;

        if (pseudo != null && password != null) {
            try {
                System.out.println("/register " + user.getPseudo() + user.getPassword());
                userDao.save(user);
                userId = user.getId();

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
                System.out.println("Merci de renseigner un pseudo et un password");
            }

        System.out.println(userId);
        return userId;
        }

    }

