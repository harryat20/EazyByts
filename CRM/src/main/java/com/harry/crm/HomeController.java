package com.harry.crm;

import com.harry.crm.dao.UserRepository;
import com.harry.crm.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping({"/login","/", "/login.html"})
    public String login() {
        return "login"; // Returns the login.html template
    }

    @GetMapping("/home.html")
    public String homePage() {
        return "home"; // Returns the home.html template
    }

    @GetMapping("task.html")
    public String task() {
        return "task"; // Returns the task.html template
    }

    @GetMapping("/ticket.html")
    public String ticket() {
        return "ticket"; // Returns the ticket.html template
    }

    @GetMapping("/team.html")
    public String team() {
        return "team"; // Returns the team.html template
    }

    @GetMapping("/loginpage.html")
    public String loginpage() {
        return "login"; // Returns the login.html template
    }

    @PostMapping("/signin")
    public String signin(@RequestParam String username, @RequestParam String password) {
        User user = userRepository.findByUsernameAndPassword(username, password);
        if (user != null) {
            return "redirect:/home";
        } else {
            return "redirect:/login";
        }
    }

    @GetMapping("/home")
    public String home() {
        return "home"; // Returns the home.html template
    }
}
