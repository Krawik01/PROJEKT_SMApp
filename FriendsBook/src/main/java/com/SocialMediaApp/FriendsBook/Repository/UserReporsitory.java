package com.SocialMediaApp.FriendsBook.Repository;


import com.SocialMediaApp.FriendsBook.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.ignoreCase;

@Repository
public class UserReporsitory {

@Autowired
    JdbcTemplate jdbcTemplate;

    public List<User> getAll() {
        return jdbcTemplate.query("SELECT id,username,password from User",
                BeanPropertyRowMapper.newInstance(User.class));
    }

    public User getById(int id){

        System.out.println( "query get by id->"+jdbcTemplate.queryForObject("SELECT * from User WHERE " +
                "id = ?", BeanPropertyRowMapper.newInstance(User.class), id));

        return jdbcTemplate.queryForObject("SELECT * from User WHERE " +
                "id = ?", BeanPropertyRowMapper.newInstance(User.class), id);


    }
//    public boolean userExists(User user){
//
//        String sql = "SELECT COUNT(username) FROM User Where username = '" + user.getUsername() + "'" + " AND password = '" + user.getPassword() + "'";
//
//        System.out.println(jdbcTemplate.queryForObject(sql,  Integer.class));
//
//        if(jdbcTemplate.queryForObject(sql,Integer.class) > 0){
//
//            System.out.println("true");
//            return true;
//        } else {
//            System.out.println("false");
//            return false;
//        }
//
//    }


    public int addUserPostMan(List<User> users) {
        users.forEach(user -> jdbcTemplate
                .update("INSERT INTO User(username, password) VALUES (?, ?)",
                        user.getUsername(), user.getPassword()
                ));



        return 1;
    }
    public int addUserPostMan(User user) {
        String sqlMe = "INSERT INTO User (username, password) VALUES ('" + user.getUsername() + "','" + user.getPassword() + "')";

        System.out.println(sqlMe);

       // jdbcTemplate.queryForObject(sqlMe, BeanPropertyRowMapper.newInstance(User.class));

        jdbcTemplate.execute(sqlMe);


        return 1;
    }

    public int addUser(User user){

        String sqlMe ="INSERT INTO User (id, username, password, email) VALUES ('" + user.getId() + "','" + user.getUsername() + "','" + user.getPassword() + "','" +user.getEmail() +"')";

        jdbcTemplate.execute(sqlMe);
        System.out.println("user has been add");
        return 1;

    }


    public int logIn(int id, String password) {

        String sqlMe = "SELECT id, password FROM User WHERE id = ? AND password = ?";

        jdbcTemplate.queryForObject(sqlMe,BeanPropertyRowMapper.newInstance(User.class), id, password);

        return 1;
    }
}
