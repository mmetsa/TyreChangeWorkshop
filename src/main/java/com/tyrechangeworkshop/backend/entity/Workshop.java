package com.tyrechangeworkshop.backend.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "workshop")
@Data
public class Workshop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany
    @JoinColumn(name = "workshop_id", referencedColumnName = "id")
    private List<WorkshopTimeslot> timeslots;
}
