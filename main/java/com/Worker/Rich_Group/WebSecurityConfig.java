package com.Worker.Rich_Group;

import org.hibernate.bytecode.enhance.internal.tracker.NoopCollectionTracker;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.inMemoryAuthentication()
                .withUser("jem")
                .password("pas")
                .roles("ADMIN")
                .and()
                .withUser("alex")
                .password("pas1")
                .roles("USER");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.httpBasic()
                        .and()
                .authorizeRequests()
                .antMatchers("/create","/update","delete/{id}","/findAll","/findById{id}","/**")
                .hasAnyRole("ADMIN","USER")
                .and()
                .formLogin();

    }

    @Bean
    public PasswordEncoder encoder () {

        return NoOpPasswordEncoder.getInstance();

    }
}
