package com.poly.controller.client;

import com.poly.common.SessionConstant;
import com.poly.entity.Accounts;
import com.poly.service.SessionDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("cart/wishlist")
public class BillController {
    private static final Logger LOGGER = LoggerFactory.getLogger(BillController.class);
    @Autowired
    SessionDAO session;
    @GetMapping("")
    public String viewBill(Model model) {
        Accounts khachHang = (Accounts) session.get(SessionConstant.CURRENT_USER);
        LOGGER.info("com/poly/controller/client/BillController.java - khachHang: "+khachHang);
        if(khachHang == null){
            LOGGER.info("com/poly/controller/client/BillController.java - checkNull");
            return "redirect:/foodshop/login";
        }
        return "cart/wishlist";
    }
}
