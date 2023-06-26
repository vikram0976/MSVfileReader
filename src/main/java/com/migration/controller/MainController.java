package com.migration.controller;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.migration.entity.Customer;
import com.migration.entity.Supply;
import com.migration.helper.Helper;
import com.migration.service.CustomerService;
import com.migration.service.SupplyService;

@RestController
@CrossOrigin("*")
public class MainController {

    @Autowired
    private CustomerService customerService;
    
    @Autowired
    private SupplyService supplyService;

    @PostMapping("/customer/upload")
    public ResponseEntity<?> upload(@RequestParam("file") MultipartFile file) {
        if (Helper.checkExcelFormat(file)) {
            //true

            this.customerService.save(file);

            return ResponseEntity.ok(Map.of("message", "File is uploaded and data is saved to db"));


        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please upload excel file ");
    }


    @GetMapping("/customer")
    public List<Customer> getAllProduct() {
        return this.customerService.getAllCustomers();
    }
    
    
    //For supply

    @PostMapping("/supply/upload")
    public ResponseEntity<?> uploadsupply(@RequestParam("file") MultipartFile file) {
        if (Helper.checkExcelFormat(file)) {
            //true

            this.supplyService.save(file);

            return ResponseEntity.ok(Map.of("message", "File is uploaded and data is saved to db"));


        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please upload excel file ");
    }


    @GetMapping("/supply")
    public List<Supply> getAllProductService() {
        return this.supplyService.getAllSupply();
    }
    //

}
