package com.migration.helper;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import com.migration.entity.Customer;
import com.migration.entity.Supply;

public class Helper {


    //check that file is of excel type or not
    public static boolean checkExcelFormat(MultipartFile file) {

        String contentType = file.getContentType();

        if (contentType.equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")) {
            return true;
        } else {
            return false;
        }

    }


    //convert excel to list of products

    public static List<Customer> convertExcelToListOfCustomer(InputStream is) {
        List<Customer> list = new ArrayList<>();

        try {

            XSSFWorkbook workbook = new XSSFWorkbook(is);

            XSSFSheet sheet = workbook.getSheet("data");

            int rowNumber = 0;
            Iterator<Row> iterator = sheet.iterator();

            while (iterator.hasNext()) {
                Row row = iterator.next();

                if (rowNumber == 0) {
                    rowNumber++;
                    continue;
                }

                Iterator<Cell> cells = row.iterator();

                int cid = 0;

                Customer customer = new Customer();

                while (cells.hasNext()) {
                    Cell cell = cells.next();

                    switch (cid) {
                        case 0:
                        	customer.setCustomerName(cell.getStringCellValue());
                            break;
                        case 1:
                        	customer.setAddressLine1(cell.getStringCellValue());
                            break;
                        case 2:
                        	customer.setCounty(cell.getStringCellValue());
                            break;
                        case 3:
                        	customer.setPostCode(cell.getStringCellValue());
                            break;
                        default:
                            break;
                    }
                    cid++;

                }

                list.add(customer);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    // supply
    public static List<Supply> convertExcelToListOfSupply(InputStream is) {
        List<Supply> list1 = new ArrayList<>();

        try {

            XSSFWorkbook workbook = new XSSFWorkbook(is);

            XSSFSheet sheet = workbook.getSheet("data");

            int rowNumber = 0;
            Iterator<Row> iterator = sheet.iterator();

            while (iterator.hasNext()) {
                Row row = iterator.next();

                if (rowNumber == 0) {
                    rowNumber++;
                    continue;
                }

                Iterator<Cell> cells = row.iterator();

                int cid = 0;

                Supply supply = new Supply();

                while (cells.hasNext()) {
                    Cell cell = cells.next();

                    switch (cid) {
                        case 0:
                        	supply.setMpan(cell.getStringCellValue());
                            break;
                        case 1:
                        	supply.setMsn(cell.getStringCellValue());
                            break;
                        case 2:
                        	supply.setSsc(cell.getStringCellValue());
                            break;
                        case 3:
                        	supply.setProfileClass((int)cell.getNumericCellValue());
                          break;
                        default:
                            break;
                    }

                    cid++;

                }

                list1.add(supply);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        return list1;

    }
    

}
