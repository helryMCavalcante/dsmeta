package com.devsuperior.dsmeta.Controller;

import com.devsuperior.dsmeta.Model.SalesModel;
import com.devsuperior.dsmeta.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class SalesController {

    @Autowired
    private SaleService saleService;

    @GetMapping
    public Page<SalesModel> findAllSales(@RequestParam(value = "minDate", defaultValue = "") String minDate,
                                         @RequestParam(value = "maxDate", defaultValue = "") String maxDate,
                                         Pageable pageable){

        return saleService.findAllSales(minDate,maxDate,pageable);
    }


    @GetMapping("/{id}")
    public Optional<SalesModel> findIdSales(@PathVariable (value = "id") Long id){
        return saleService.findSalesId(id);
    }
}
