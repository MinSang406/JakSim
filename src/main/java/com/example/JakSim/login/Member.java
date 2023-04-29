package com.example.JakSim.login;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Member {
        private Long id;
        private String email;
        private String password;
        private String name;
        private LocalDateTime registerDateTime;

        public void changePassword(String oldPassword, String newPassword) {
            this.password = newPassword;
        }
        @Override
        public String toString() {
            return "id: "+ id + " email: "+email + " name: "+name
                    +" password: "+password;
        }
        public boolean checkPassword(String password) {
            return this.password.equals(password);
        }
}
