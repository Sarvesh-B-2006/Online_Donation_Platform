package com.donationplatform.donation_platform.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.donationplatform.donation_platform.model.User;



public interface UserRepository 
extends JpaRepository<User,Long>{


    boolean existsByEmail(String email);


    User findByEmail(String email);


}