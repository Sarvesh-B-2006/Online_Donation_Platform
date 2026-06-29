package com.donationplatform.donation_platform.controller;


import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/users")
public class UserController {



@GetMapping("/profile")
public String profile(){


return "User Profile Access Granted";


}


}