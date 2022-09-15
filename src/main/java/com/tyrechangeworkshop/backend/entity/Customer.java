package com.tyrechangeworkshop.backend.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "customer")
@Data
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "birth_date")
    private LocalDateTime birthDate;

    @Column(name = "phone_nr")
    private String phoneNr;

    @Column(name = "email")
    private String email;

    @OneToMany
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private List<Reservation> reservations;
}
