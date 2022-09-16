package com.tyrechangeworkshop.backend.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "reservation")
@Data
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "comment")
    private String comment;

    @ManyToOne
    private Customer customer;

    @OneToOne(mappedBy = "reservation")
    private WorkshopTimeslot timeslot;
}
