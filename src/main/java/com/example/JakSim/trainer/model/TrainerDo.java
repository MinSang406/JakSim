package com.example.JakSim.trainer.model;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TrainerDo {
    private String user_id;
    private String uinsta;
    private String uintroduce;
    private String exp;
    private String cert;
    private String photo_cert;
    private String career;
    private String gymmap;
    private int ptType;
    private int ptCount;
    private int ptPay;
    private String photo;
    @Override
    public String toString() {
        return "TrainerInfo{" +
                "uinsta='" + uinsta + '\'' +
                ", uintroduce='" + uintroduce + '\'' +
                ", exp='" + exp + '\'' +
                ", cert='" + cert + '\'' +
                ", photo_cert='" + photo_cert + '\'' +
                ", career='" + career +  '\'' +
                ", user_answer='" + gymmap + '\'' +
                ", ptType=" + ptType + '\'' +
                ", ptType=" + ptCount + '\'' +
                ", ptType=" + ptPay + '\'' +
                ", user_birth='" + photo + '\'' +
                '}';
    }

}
