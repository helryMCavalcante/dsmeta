package com.devsuperior.dsmeta.Controller;

import com.devsuperior.dsmeta.Model.SalesModel;
import com.devsuperior.dsmeta.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class SalesController {

    @Autowired
    private Service saleService;

    @GetMapping
    public List<SalesModel> findAllSales(){
        return saleService.findAllSales();
    }
    @GetMapping("/{id}")
    public ResponseEntity<SalesModel> findIdSales(@PathVariable (value = "id") Long id){
        if(!(id ==null))
        return saleService.findSalesId(id);
    }
}
