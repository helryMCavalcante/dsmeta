package com.devsuperior.dsmeta.Repository;

import com.devsuperior.dsmeta.Model.SalesModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface SalesRepository extends JpaRepository<SalesModel, Long> {

    @Query("SELECT obj FROM SalesModel obj WHERE obj.date BETWEEN :min AND :max ORDER BY obj.amount DESC")
    Page<SalesModel> findAllSales(LocalDate min, LocalDate max, Pageable pageable);

    public Optional<SalesModel> findById(SalesModel Long);
}
