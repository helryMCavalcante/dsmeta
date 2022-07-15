package com.devsuperior.dsmeta.Repository;

import com.devsuperior.dsmeta.Model.SalesModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SalesRepository extends JpaRepository<SalesModel, Long> {

    public Optional<SalesModel> findById(SalesModel Long);
}
