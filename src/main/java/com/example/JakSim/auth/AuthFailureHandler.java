package com.example.JakSim.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class AuthFailureHandler extends SimpleUrlAuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        String msg = "Invalid Account or Password";

        if(exception instanceof DisabledException){
            msg = "Disabled Exception Account";
        }else if(exception instanceof CredentialsExpiredException){
            msg = "Credentials Expired Exception Account";
        }else if(exception instanceof BadCredentialsException){
            msg = "Bad Credentials Expired Exception Account";
        }

        setDefaultFailureUrl("/login?error=true&exception=" + msg); //애러 페이지 이렇게 설정해도 좋을듯?

        super.onAuthenticationFailure(request, response, exception);
    }
}
