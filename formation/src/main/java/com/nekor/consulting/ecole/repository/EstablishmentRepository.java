package com.nekor.consulting.ecole.repository;

import com.nekor.consulting.ecole.model.Establishment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface EstablishmentRepository extends JpaRepository<Establishment, String>, JpaSpecificationExecutor<Establishment> {

    Optional<Establishment> findByCity(String city);
}
