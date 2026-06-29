package com.donationplatform.donation_platform.config;


import org.springframework.context.annotation.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Configuration
public class PasswordConfig {


@Bean
public BCryptPasswordEncoder encoder(){

return new BCryptPasswordEncoder();

}

}