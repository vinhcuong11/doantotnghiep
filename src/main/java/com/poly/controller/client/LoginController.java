package com.poly.controller.client;

import com.poly.common.SessionConstant;
import com.poly.entity.Accounts;
import com.poly.service.AccountService;
import com.poly.service.SessionDAO;
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
        if(session.get(SessionConstant.ERROR)!=null){
            model.addAttribute("message", "Sai mật khẩu hoặc tài khoản");
        }
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
                session.set(SessionConstant.ERROR, SessionConstant.ERROR_CODE);
                return "redirect:/foodshop/login";
            } else if (userResponse.getPassword().equals(userRequest.getPassword())) {
                session.set("user", userResponse);
                session.set(SessionConstant.ERROR, null);
                return "redirect:/foodshop";
            } else {
                session.set(SessionConstant.ERROR, SessionConstant.ERROR_CODE);
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
            LOGGER.info("com/poly/controller/client/LoginController.java - Username:"+userRequest.getUsername());
            Accounts userResponse = accountServ.getUser(userRequest.getUsername());
            LOGGER.info("com/poly/controller/client/LoginController.java - userResponse"+userResponse);
            if(userResponse==null){
                LOGGER.info("com/poly/controller/client/LoginController.java -Check Empty");
                accountServ.SaveAccount(userRequest);
                return "redirect:/foodshop/login";
            }
            return "redirect:/foodshop/login/sign-up";
        } catch (Exception e) {
            LOGGER.error("com/poly/controller/client/LoginController.java - Exception: "+e);
            return "redirect:/foodshop/login/sign-up";
        }
    }

}
