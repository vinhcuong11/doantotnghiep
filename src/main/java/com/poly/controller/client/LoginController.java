package com.poly.controller.client;

import com.poly.common.SessionConstant;
import com.poly.entity.Accounts;
import com.poly.service.AccountService;
import com.poly.service.SessionDAO;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller

@RequestMapping("/foodshop/login")
public class LoginController {
    @Autowired
    SessionDAO session;
    private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);
    @Autowired
    private AccountService accountServ;

    @GetMapping("")
    public String index(Model model) {
        model.addAttribute("userRequest", new Accounts());
        return "login/login";
    }

    @GetMapping("/sign-up")
    public String signUp(Model model) {
        model.addAttribute("userRequest", new Accounts());
        return "login/signup";
    }

    @PostMapping("/login-user")
    public String doPostLogin(@ModelAttribute("userRequest") Accounts userRequest) {
        try {
            Accounts userResponse = accountServ.getUser(userRequest.getUsername());
            if (userResponse.getName().isEmpty()) {
                return "redirect:/foodshop/login";
            } else if (userResponse.getPassword().equals(userRequest.getPassword())) {
                session.set("user", userResponse);
                return "redirect:/foodshop";
            } else {
                return "redirect:/foodshop/login";
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return "redirect:/foodshop/login";
        }
    }

    @PostMapping("/register")
    public String doPostRegister(@ModelAttribute("userRequest") Accounts userRequest) {
        try {
            LOGGER.info("Username:"+userRequest.getUsername());
            Accounts userResponse = accountServ.getUser(userRequest.getUsername());
            LOGGER.info("userResponse"+userResponse);
            if(userResponse==null){
                LOGGER.info("Check Empty");
                accountServ.SaveAccount(userRequest);
                return "redirect:/foodshop/login";
            }
            return "redirect:/foodshop/login/sign-up";
        } catch (Exception e) {
            LOGGER.error("Exception: "+e);
            return "redirect:/foodshop/login/sign-up";
        }
    }

}
