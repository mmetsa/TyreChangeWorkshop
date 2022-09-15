package com.tyrechangeworkshop.backend.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "workshop_timeslot")
@Data
public class WorkshopTimeslot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Workshop workshop;

    @ManyToOne
    private Timeslot timeslot;
}
