package com.donationplatform.donation_platform.service;


import com.donationplatform.donation_platform.dto.LoginRequest;
import com.donationplatform.donation_platform.dto.LoginResponse;
import com.donationplatform.donation_platform.dto.RegisterRequest;
import com.donationplatform.donation_platform.model.User;
import com.donationplatform.donation_platform.repository.UserRepository;
import com.donationplatform.donation_platform.security.JwtService;


import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;



@Service
public class UserService {



    private final UserRepository repository;

    private final PasswordEncoder encoder;

    private final JwtService jwtService;



    public UserService(
            UserRepository repository,
            PasswordEncoder encoder,
            JwtService jwtService
    ){

        this.repository = repository;
        this.encoder = encoder;
        this.jwtService = jwtService;

    }





    // ================= REGISTER =================


    public User register(RegisterRequest request){



        String email = request.getEmail()
                .trim()
                .toLowerCase();



        if(repository.existsByEmail(email)){


            throw new RuntimeException(
                    "Email already exists"
            );

        }



        User user = new User();



        user.setName(
                request.getName()
        );


        user.setEmail(email);



        user.setPassword(
                encoder.encode(
                        request.getPassword()
                )
        );



        user.setRole(
                request.getRole()
        );



        return repository.save(user);



    }







    // ================= LOGIN =================



    public LoginResponse login(LoginRequest request){



        String email =
                request.getEmail()
                .trim()
                .toLowerCase();



        User user =
                repository.findByEmail(email);



        if(user == null){


            throw new RuntimeException(
                    "User not found with email: "
                    + email
            );


        }





        boolean passwordMatch =
                encoder.matches(
                        request.getPassword(),
                        user.getPassword()
                );





        if(!passwordMatch){



            throw new RuntimeException(
                    "Invalid password"
            );


        }







        String token =
                jwtService.generateToken(
                        user.getEmail()
                );






        return new LoginResponse(

                token,

                "Login Successful"

        );



    }



}