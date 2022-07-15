package com.devsuperior.dsmeta;

import com.devsuperior.dsmeta.Model.SalesModel;
import com.devsuperior.dsmeta.Repository.SalesRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
public class Service {

    @Autowired
    private SalesRepository repository;

    public List<SalesModel> findAllSales(){
        return repository.findAll();
    }

    public Optional<SalesModel> findSalesId(Long  id){
        return repository.findById(id);
    }
}
