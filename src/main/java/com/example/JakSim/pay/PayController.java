package com.example.JakSim.pay;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PayController {
    @PreAuthorize("isAuthenticated()")
    @GetMapping("/pay")
    public String BeforePay(){
        return "content/pay/pay";
    }

}
