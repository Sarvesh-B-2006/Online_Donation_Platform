package com.donationplatform.donation_platform.controller;


import com.donationplatform.donation_platform.dto.LoginRequest;
import com.donationplatform.donation_platform.dto.RegisterRequest;
import com.donationplatform.donation_platform.dto.LoginResponse;
import com.donationplatform.donation_platform.model.User;
import com.donationplatform.donation_platform.service.UserService;


import jakarta.validation.Valid;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:5173")
public class AuthController {



    private final UserService service;



    public AuthController(UserService service){

        this.service = service;

    }






    // ================= REGISTER =================


    @PostMapping("/register")
    public ResponseEntity<?> register(

            @Valid @RequestBody RegisterRequest request

    ){


        try{


            User user =
                    service.register(request);



            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(user);



        }
        catch(Exception e){


            return ResponseEntity
                    .badRequest()
                    .body(e.getMessage());


        }


    }







    // ================= LOGIN =================



    @PostMapping("/login")
    public ResponseEntity<?> login(

            @Valid @RequestBody LoginRequest request

    ){



        try{


            LoginResponse response =
                    service.login(request);



            return ResponseEntity.ok(response);



        }
        catch(Exception e){


            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body(e.getMessage());


        }


    }



}