package com.poly.controller.client;

import com.poly.common.SessionConstant;
import com.poly.entity.Accounts;
import com.poly.entity.Role;
import com.poly.jwt.CustomUser;
import com.poly.jwt.JwtTokenProvider;
import com.poly.service.AccountService;
import com.poly.service.SessionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpSession;

@Controller

@RequestMapping("/foodshop/login")
public class LoginController {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);
    @Autowired
    SessionDAO session;

    @Autowired
    private AuthenticationManager authenManager;

    BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();

    @Autowired
    private AccountService accountServ;

    @Autowired
    private JwtTokenProvider tokenProvider;

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

//    @PostMapping("/login-user")
//    public String doPostLogin(@ModelAttribute("userRequest") Accounts userRequest) {
//        try {
//            Accounts userResponse = accountServ.getUser(userRequest.getUsername());
//            if (userResponse.getName().isEmpty()) {
//                session.set(SessionConstant.ERROR, SessionConstant.ERROR_CODE);
//                return "redirect:/foodshop/login";
//            } else if (userResponse.getPassword().equals(userRequest.getPassword())) {
//                session.set("user", userResponse);
//                session.set(SessionConstant.ERROR, null);
//                return "redirect:/foodshop";
//            } else {
//                session.set(SessionConstant.ERROR, SessionConstant.ERROR_CODE);
//                return "redirect:/foodshop/login";
//            }
//        } catch (Exception ex) {
//            ex.printStackTrace();
//            return "redirect:/foodshop/login";
//        }
//    }

    @PostMapping("/checkin")
    public String PostloginHome(Model model, @ModelAttribute("userRequest") @Validated Accounts userlogin
    ) {
        LOGGER.info("com/poly/controller/client/LoginController.java - PostloginHome - START");
        LOGGER.info("com/poly/controller/client/LoginController.java - Accounts:"+userlogin.toString());
        UsernamePasswordAuthenticationToken authenInfo = new UsernamePasswordAuthenticationToken(
                userlogin.getUsername(),userlogin.getPassword());
        Authentication authentication = authenManager.authenticate(authenInfo);
        CustomUser customUser = (CustomUser) authentication.getPrincipal();
        Accounts userResponse = accountServ.getUser(userlogin.getUsername());
        LOGGER.info("com/poly/controller/client/LoginController.java - userResponse.getUsername:"+userResponse.getUsername());
        boolean loginStatus = bcrypt.matches(userlogin.getPassword(), userResponse.getPassword());
        LOGGER.info("com/poly/controller/client/LoginController.java - Repo hash "+ userResponse.getPassword());
        LOGGER.info("com/poly/controller/client/LoginController.java - Login hash "+ userlogin.getPassword());
        LOGGER.info("com/poly/controller/client/LoginController.java - loginStatus"+loginStatus);
        if (userResponse != null && loginStatus) {
            Role RoleUserResponse = userResponse.getRole();
            // tạo Sesstion tại Server
            session.set(SessionConstant.CURRENT_USER, userResponse);
            session.set(SessionConstant.CURRENT_ROLE, RoleUserResponse);
            LOGGER.info("RoleName: "+RoleUserResponse.getRoleName());
            session.set(SessionConstant.JWT, tokenProvider.generateToken(customUser));
            session.set(SessionConstant.CURRENT_USER, userResponse);
            session.set(SessionConstant.ERROR, null);
            return "redirect:/foodshop";
        } else {
            String message = "Login Failed, please try again!";
            model.addAttribute("message", message);
            System.out.println(message);
            session.set(SessionConstant.ERROR, SessionConstant.ERROR_CODE);
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
                Role rolcustomere = new Role(2,"");
                userRequest.setRole(rolcustomere);
                userRequest.setPassword(bcrypt.encode(userRequest.getPassword()));
                accountServ.SaveAccount(userRequest);
                return "redirect:/foodshop/login";
            }
            return "redirect:/foodshop/login/sign-up";
        } catch (Exception e) {
            LOGGER.error("com/poly/controller/client/LoginController.java - Exception: "+e);
            return "redirect:/foodshop/login/sign-up";
        }
    }

    boolean areValuesAlike(String value1,String value2){
        return value1.equals(value2);
    }

}
