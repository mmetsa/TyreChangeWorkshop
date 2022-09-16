package com.tyrechangeworkshop.backend.repository;

import com.tyrechangeworkshop.backend.entity.Workshop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkshopRepository extends JpaRepository<Workshop, Long> {
}
