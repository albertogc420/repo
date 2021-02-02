package com.jgarcia.micro.shopping.model;

import lombok.Builder;
import lombok.Data;

import javax.swing.plaf.synth.Region;

@Data
@Builder
public class Customer {
    private Long id;


    private String numberID;

    private String firstName;


    private String lastName;


    private String email;


    private String photoUrl;

    private Region region;

    private String state;
}
