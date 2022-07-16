package com.devsuperior.dsmeta;
import org.springframework.stereotype.Service;
import com.devsuperior.dsmeta.Model.SalesModel;
import com.devsuperior.dsmeta.Repository.SalesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;

@Service
public class SaleService {


    @Autowired
    private SalesRepository repository;

    public Page<SalesModel> findAllSales(String minDate, String maxDate, Pageable pageable){

        LocalDate today = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());

        LocalDate min = minDate.equals("") ? today.minusYears(365) : LocalDate.parse(minDate);
        LocalDate max = maxDate.equals("") ? today : LocalDate.parse(maxDate);

        return repository.findAllSales(min, max, pageable);
    }



    public Optional<SalesModel> findSalesId(Long  id){

        return repository.findById(id);
    }
}
