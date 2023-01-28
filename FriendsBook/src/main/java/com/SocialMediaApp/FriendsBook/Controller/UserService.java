package com.SocialMediaApp.FriendsBook.Controller;

import com.SocialMediaApp.FriendsBook.Model.User;
import com.SocialMediaApp.FriendsBook.Repository.UserReporsitory;
import com.SocialMediaApp.FriendsBook.Security.UserSecurity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@RestController
@RequestMapping("/users")
public class UserService {

    @Autowired
    UserReporsitory userRepository;

    @Autowired
    UserSecurity userSecurity;

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


    @PostMapping("/LogIn")
    public ModelAndView userLogIn(@ModelAttribute User user, Model model) {
        System.out.println(user.toString());
        model.addAttribute("message", user.getUsername() + " inserted");
        System.out.println(model.getAttribute("message"));
        if (userSecurity.userExists(user)) {
            return welcomeLogIn(user, model);
        } else {
           welcomeRegister(user,model);
            return null;
        }
    }

    @PostMapping("/register")
    public ModelAndView userRegister(@ModelAttribute User user, Model model){
        System.out.println("users register ");
        return welcomeRegister(user,model);
    }

    @PostMapping("/profile")
    public ModelAndView userRegisterAccepted(@ModelAttribute User user, Model model){
        System.out.println(user.toString());
        model.addAttribute("message", user.getUsername() + " inserted");
        System.out.println(model.getAttribute("message"));
        if (!userSecurity.userExists(user)) {
            System.out.println("sprawdzam");
            userRepository.addUser(user);
            System.out.println("UserAdded");
            return welcomeLogIn(user, model);
        } else {
            System.out.println("User exists");
            return welcomeRegister(user,model);
        }
    }


    public ModelAndView welcomeLogIn(User user, Model model) {
        ModelAndView modelAndView = new ModelAndView();
        model.addAttribute("message", user.getUsername() + "inserted");
        modelAndView.setViewName("welcome.html");
        System.out.println(modelAndView);
        return modelAndView;
    }
    public ModelAndView welcomeRegister(User user, Model model) {
        System.out.println("users register!");
        ModelAndView modelAndView = new ModelAndView();
        model.addAttribute("message", user.getUsername() + "inserted");

        modelAndView.setViewName("register.html");
        System.out.println(modelAndView);
        return modelAndView;
    }




}
