package com.example.JakSim.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.security.servlet.SecurityFilterAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@RequiredArgsConstructor
@Configuration
@EnableWebSecurity
public class SecurityConfiguration{
    private final AuthSuccessHandler authSuccessHandler;
    private final AuthFailureHandler authFailureHandler;

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder(); //단방향 해시함수라고 함;;
    }


    @Bean
    AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception{
        return authenticationConfiguration.getAuthenticationManager();
    }


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.csrf().disable();
        http.authorizeHttpRequests()
<<<<<<< HEAD
                .mvcMatchers("/", "/login/**", "/error/**", "/js/**", "/css/**", "/images/**", "/pay/**").permitAll()
=======
<<<<<<< HEAD
                .mvcMatchers("/", "/login/**", "/register/**","/error/**", "/javascript/**", "/css/**", "/image/**","trainer/**").permitAll()
=======
                .mvcMatchers("/", "/login/**", "/register/**","/error/**", "/javascript/**", "/css/**", "/image/**", "/find/**").permitAll()
>>>>>>> b3d6b378cdde027582dfc9be4fd13da772ffe7cc
>>>>>>> 32d96443c74b39426af4a9a62e75d87413a9e258
                .anyRequest().authenticated();
        http.formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/login/action")
                .successHandler(authSuccessHandler)
                .failureHandler(authFailureHandler);
        http.logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/")
                .invalidateHttpSession(true);
        //.deleteCookies()
        http.sessionManagement()
                .maximumSessions(1)
                .maxSessionsPreventsLogin(false)
                .expiredUrl("/login?error=true&exception=sessionExpired");
        http.rememberMe()
                .key("?")
                .alwaysRemember(false)
                .tokenValiditySeconds(1800) //in seconds 30분 -> 30 * 60
                .rememberMeParameter("remember-me");
        return http.build();
    }
}
