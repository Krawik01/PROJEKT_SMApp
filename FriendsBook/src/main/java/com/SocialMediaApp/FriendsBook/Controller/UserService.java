package com.SocialMediaApp.FriendsBook.Controller;

import com.SocialMediaApp.FriendsBook.Model.User;
import com.SocialMediaApp.FriendsBook.Repository.UserReporsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/users")
public class UserService {

    @Autowired
    UserReporsitory userRepository;

    @Autowired
    IndexController indexController;

    @GetMapping("")
    public List<User> getAll(){
        return userRepository.getAll();
    }


    @GetMapping("/test")
    public String test(){
        return "TEST";
    }



    @GetMapping("/{id}")
    public User getById(@PathVariable("id") int id){
        return userRepository.getById(id);
    }

    @PostMapping("/add")
    public int add(List<User> users){
        return userRepository.addUserPostMan(users);
    }


//    @PostMapping("/register")
//
//    public int add(@RequestBody User user){
//        return userRepository.addUser(user);
//    }
    @PostMapping("/register")
    public String userRegistration(@ModelAttribute User user, Model model){
        System.out.println(user.toString());
        userRepository.addUser(user);
        System.out.println(user.getUsername());
        model.addAttribute("message", user.getUsername() + "inserted");
//
//           return "welcome";
//
//       } else {
//           System.out.println("error");
//           return "welcome";
//          // indexController.index();

       return "welcome";
    }






}
