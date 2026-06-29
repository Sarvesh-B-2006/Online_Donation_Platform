package com.donationplatform.donation_platform.model;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Role {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String roleName;



    @OneToMany(mappedBy="role")
    private List<User> users;


}