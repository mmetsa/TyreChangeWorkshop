package com.tyrechangeworkshop.backend.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "workshop")
public class Workshop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany
    @JoinColumn(name = "timeslot_id", referencedColumnName = "id")
    private List<WorkshopTimeslot> timeslots;
}
