package com.SocialMediaApp.FriendsBook.Security;

import com.SocialMediaApp.FriendsBook.Model.User;
import com.SocialMediaApp.FriendsBook.Repository.UserReporsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserSecurity {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public boolean userExists(User user) {

        String sql = "SELECT COUNT(username) FROM User Where username = '" + user.getUsername() + "'" + " AND password = '" + user.getPassword() + "'";

        System.out.println(jdbcTemplate.queryForObject(sql, Integer.class));

        if (jdbcTemplate.queryForObject(sql, Integer.class) > 0) {
            System.out.println("true");
            return true;
        } else {
            System.out.println("false");
            return false;
        }

    }
}
