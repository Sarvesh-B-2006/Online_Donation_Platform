package com.donationplatform.donation_platform.controller;


import org.springframework.web.bind.annotation.*;



@RestController
public class TestController {



@GetMapping("/test-db")
public String test(){


return "Database Connected Successfully";


}


}