package com.springboot.rest.crudcontact.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.springboot.rest.crudcontact.service.DomainUserDetailsService;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
/*WebSecurityConfigurerAdapter a convenience class that allows customization to both
 websecurity and HttpSecurity
 */

    @Bean
    public UserDetailsService userDetailsService() {
        return new DomainUserDetailsService();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService()).passwordEncoder(passwordEncoder());
    }

    private PasswordEncoder passwordEncoder()	 {
        return new BCryptPasswordEncoder(); 
        
//BCryptPasswordEncoder : implementation of PasswordEncoder that use Bcrypt strong hashing function
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().and()
                .formLogin()
                .loginProcessingUrl("/api/authentification")
            //    .usernameParameter("nom")
                .permitAll()
                .and()
                .logout()
                .logoutUrl("/api/logout")
                .permitAll()
                .and()
                .authorizeRequests()
                .antMatchers("/api/authentification").permitAll()
                .antMatchers("/api/contacts").authenticated()
                .antMatchers("/api/**").permitAll()
                .antMatchers("/api/admin").hasAnyAuthority("ADMIN", "COMMERCIEL");

    }
}
