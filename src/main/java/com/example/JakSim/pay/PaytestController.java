package com.example.JakSim.pay;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PaytestController {

    @GetMapping("/paytest")
    public String beforepay() {
        return "content/pay/paytest";
    }

}
