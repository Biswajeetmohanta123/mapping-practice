package com.geekster.MappingPractice.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Laptop {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String ID;
    private String name;
    private String brand;
    private Integer price;

    @OneToOne()
    private Student student;
}
