package com.migration.service;


import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.migration.entity.Supply;
import com.migration.helper.Helper;
import com.migration.repo.SupplyRepo;

@Service
public class SupplyService {

    @Autowired
    private SupplyRepo supplyRepo;

    public void save(MultipartFile file) {

        try {
            List<Supply> supply = Helper.convertExcelToListOfSupply(file.getInputStream());
            this.supplyRepo.saveAll(supply);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public List<Supply> getAllSupply() {
        return this.supplyRepo.findAll();
    }


}
