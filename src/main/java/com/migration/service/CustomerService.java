package com.migration.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.migration.entity.Customer;
import com.migration.helper.Helper;
import com.migration.repo.CustomerRepo;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepo customerRepo;

    public void save(MultipartFile file) {

        try {
            List<Customer> products = Helper.convertExcelToListOfCustomer(file.getInputStream());
            this.customerRepo.saveAll(products);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public List<Customer> getAllCustomers() {
        return this.customerRepo.findAll();
    }


}
