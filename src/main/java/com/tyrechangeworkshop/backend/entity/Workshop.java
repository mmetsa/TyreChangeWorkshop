package com.tyrechangeworkshop.backend.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "workshop")
public class Workshop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "workshop")
    private List<WorkshopTimeslot> timeslots;
}
