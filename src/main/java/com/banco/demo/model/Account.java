package com.banco.demo.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity(name = "tb_account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String number;
    private String agency;
    @Column(scale = 2, precision =13)
    private Number baalnce;
    @Column(name = "available_limit", scale = 2, precision =13)

    private Number limit;


}
