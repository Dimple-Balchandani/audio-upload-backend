package com.vs.Syntoy.authentication;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
  @Override
  protected void configure(HttpSecurity http) throws Exception {
//    http.csrf().disable().authorizeRequests()
//        .antMatchers("/", "/assets/**", "/*.js", "/*.js.map", "/*.woff2", "/*.ttf", "/*.svg", "/*.ico", "/*.html" , "/configuration/ui", "/swagger-resources", "/configuration/security", "/v2/api-docs","/swagger-ui.html", "/webjars/**", "/swagger-resources/configuration/ui", "/swagger-ui.html", "/swagger-resources/configuration/security").permitAll()
//        .antMatchers(HttpMethod.POST, "/admin/login/").permitAll()
//        .anyRequest().authenticated()
//        .and()
//        // We filter the api/login requests
//        .addFilterBefore(new JWTLoginFilter("/admin/login/", authenticationManager()),
//                UsernamePasswordAuthenticationFilter.class)
//        // And filter other requests to check the presence of JWT in header
//        .addFilterBefore(new JWTAuthenticationFilter(),
//                UsernamePasswordAuthenticationFilter.class);
	http.csrf().disable();
	http.addFilterBefore(new JWTLoginFilter("/admin/login/", authenticationManager()), UsernamePasswordAuthenticationFilter.class);
    http.authorizeRequests().antMatchers("/").permitAll();
  }

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    // Create a default account
	  
	  auth.inMemoryAuthentication().withUser("admin").password("password123*").roles("ADMIN");
	  auth.inMemoryAuthentication().withUser("jyoti").password("jyoti123*").roles("ADMIN");
	  auth.inMemoryAuthentication().withUser("rajat").password("rajat123*").roles("ADMIN");
   
  }
}