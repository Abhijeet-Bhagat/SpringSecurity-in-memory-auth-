package com.sec.demo_sec;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class DemoConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("Abhi")
                .password("1234")
                .authorities("dev")
                .and()
                .withUser("Chandu")
                .password("1234")
                .authorities("qa");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic().and() //httpbasic used for rendering json response in postman otherwise it gives a html page
                .authorizeRequests()
                .antMatchers("/testcode/**").hasAuthority("qa")
                .antMatchers("/devcode/**").hasAuthority("dev")
                .antMatchers("/accessserver/**").hasAnyAuthority("dev", "qa")
                .antMatchers("/home").permitAll()
                .and()
                .formLogin();
    }

    @Bean
    PasswordEncoder getPE(){
        return  NoOpPasswordEncoder.getInstance();
    }
}
