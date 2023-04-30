package com.example.JakSim.auth;

import com.example.JakSim.login.model.LoginDao;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class AuthSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
    @Autowired
    private DataSource ds;
    private LoginDao loginDao;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authentication) throws IOException, ServletException {
        //loginDao = new LoginDao(ds);
        //loginDao.updateUserLastLogin(authentication.getName()); 찾아보다가 꽤나 재미난 거 찾았는데, 마지막으로 로그인한 시간을 DB에 저장하는거임
        setDefaultTargetUrl("/");
        super.onAuthenticationSuccess(request, response, authentication);
    }
}
