package com.tyrechangeworkshop.backend.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "workshop_timeslot")
public class WorkshopTimeslot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @ManyToOne
    private Workshop workshop;

    @ManyToOne
    private Timeslot timeslot;

    @OneToOne
    private Reservation reservation;
}
