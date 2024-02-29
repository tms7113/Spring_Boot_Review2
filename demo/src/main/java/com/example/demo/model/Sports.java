package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Sports {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int orderidnumber;
    private String productName;
    private int quantity;
    private int price;
    @JsonBackReference
    @ManyToOne()
    @JoinColumn(name = "sub_id")
    private Register register;

}