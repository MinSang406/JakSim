<<<<<<< HEAD:src/main/java/com/example/JakSim/trainer/TrainerController.java
=======
package com.example.JakSim.trainer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TrainerController {
    @GetMapping("trainer/register")
    public String create() {
        return "content/trainer/trainerRegister";
    }
}
>>>>>>> 32d96443c74b39426af4a9a62e75d87413a9e258:src/main/java/com/example/JakSim/trainer/controller/TrainerController.java
