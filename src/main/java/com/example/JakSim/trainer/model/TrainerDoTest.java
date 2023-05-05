package com.example.JakSim.trainer.model;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TrainerDoTest {
    private String uinsta;
    private String uintroduce;
    private String gymmap;
    @Override
    public String toString() {
        return "TrainerInfo{" +
                "uinsta='" + uinsta + '\'' +
                ", uintroduce='" + uintroduce + '\'' +
                ", gymmap='" + gymmap + '\'' +
                '}'
                ;
    }

}
