package com.SocialMediaApp.FriendsBook.Repository;


import com.SocialMediaApp.FriendsBook.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserReporsitory {

@Autowired
    JdbcTemplate jdbcTemplate;

    public List<User> getAll() {
        return jdbcTemplate.query("SELECT id,username,password from User",
                BeanPropertyRowMapper.newInstance(User.class));
    }

    public User getById(int id){
        return jdbcTemplate.queryForObject("SELECT * from User WHERE " +
                "id = ?", BeanPropertyRowMapper.newInstance(User.class), id);
    }

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

        String sqlMe ="INSERT INTO User (id, username, password) VALUES ('" + user.getId() + "','" + user.getUsername() + "','" + user.getPassword() + "')";

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
