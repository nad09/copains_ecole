package com.example.copains_ecole.model.dao;


import com.example.copains_ecole.model.UserBean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface UserDao extends JpaRepository<UserBean, Long> {

    UserBean findByPseudo(String pseudo);

    UserBean findBySession(String session);

    @Query("Select NEW com.example.copains_ecole.model.UserBean(pseudo, longitude, latitude, group_users, session) from UserBean where latitude IS NOT NULL and longitude IS NOT NULL ")
    ArrayList<UserBean> getPseudoLonLatSession();



}
