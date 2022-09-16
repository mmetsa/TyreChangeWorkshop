package com.tyrechangeworkshop.backend.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "timeslot")
public class Timeslot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "start_time")
    private LocalDateTime startTime;

    @Column(name = "end_time")
    private LocalDateTime endTime;

    @OneToMany(mappedBy = "timeslot")
    private List<WorkshopTimeslot> timeslots;
}
