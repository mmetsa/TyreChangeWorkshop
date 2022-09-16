package com.tyrechangeworkshop.backend.entity;

import javax.persistence.*;

@Entity
@Table(name = "workshop_timeslot")
public class WorkshopTimeslot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Workshop workshop;

    @ManyToOne
    private Timeslot timeslot;

    @OneToOne
    private Reservation reservation;
}
