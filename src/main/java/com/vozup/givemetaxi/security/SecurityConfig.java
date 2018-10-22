package com.vozup.givemetaxi.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                //requests matched against are fully accessible
                //.antMatchers("/pages/login.xhtml").permitAll()
                //.antMatchers("/javax.faces.resource/**").permitAll()
                .antMatchers("/pages/admin/**").hasAnyRole("ADMIN")
                .antMatchers("/pages/operator/**").hasAnyRole("USER")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                //form-based authentication is enabled with a custom login page and failure url
                .loginPage("/pages/login.xhtml").permitAll().defaultSuccessUrl("/pages/invalid_password.xhtml")
                .failureUrl("/pages/error.xhtml?error=true")
                .defaultSuccessUrl("/pages/admin/index.xhtml");
//                .and()
//                .logout()
//                .logoutSuccessUrl("/pages/login.xhtml");
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

        auth.inMemoryAuthentication()
                .withUser("user").password("password").roles("USER")
                .and()
                .withUser("admin").password("password").roles("ADMIN");
    }

}
