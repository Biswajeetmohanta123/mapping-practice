package com.geekster.MappingPractice.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String landmark;
    private String zipcode;
    private String district;
    private String state;
    private String country;

    @OneToOne()
    private Student student;

}
