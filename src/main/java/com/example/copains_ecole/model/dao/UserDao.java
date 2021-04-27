package com.example.copains_ecole.model.dao;

import com.example.copains_ecole.model.UserBean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface UserDao extends JpaRepository<UserBean, Long> {
    ArrayList<UserBean> findByPseudo(String pseudo);
    //ArrayList<UserBean> findByGroup_users(Integer group_users);
}
