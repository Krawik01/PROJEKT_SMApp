<<<<<<< HEAD
package com.SocialMediaApp.FriendsBook.Controller;

import com.SocialMediaApp.FriendsBook.Model.User;
import com.SocialMediaApp.FriendsBook.Repository.UserReporsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class IndexController {

    @Autowired
    UserReporsitory userReporsitory;

    @GetMapping("")
    public String index() {
        return "index";
    }



//    @PostMapping("/register")
//    public String registerUser(User user, Model model) {
//        System.out.println(user.toString());
//
//        System.out.println(user.getUsername());
//        model.addAttribute("message", user.getUsername());
//        return "welcome";
//
//    }

}


=======
//package com.SocialMediaApp.FriendsBook.Controller;
//
//import com.SocialMediaApp.FriendsBook.Model.User;
//import com.SocialMediaApp.FriendsBook.Repository.UserReporsitory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.converter.json.GsonBuilderUtils;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//
//@Controller
//public class IndexController {
//
//    @Autowired
//    UserReporsitory userReporsitory;
//
//    @GetMapping("")
//    public String welcome() {
//        return "welcome";
//    }
//
//
//
////    @PostMapping("/register")
////    public String registerUser(User user, Model model) {
////        System.out.println(user.toString());
////
////        System.out.println(user.getUsername());
////        model.addAttribute("message", user.getUsername());
////        return "welcome";
////
////    }
//
//}
//
//
>>>>>>> d43a775 (css added)
