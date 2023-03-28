package com.example.shop_online.admincontroller;

import com.example.shop_online.payload.response.ResponseData;
import com.example.shop_online.repository.admin.OrderDetailRepositoty;
import com.example.shop_online.service.admin.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
public class InventoryReport {

    @Autowired
    ReportService inventoryService;
    @Autowired
    OrderDetailRepositoty orderDetailRepositoty;

        @RequestMapping("/inventory")
        public ResponseEntity<?> getInventory() {
            ResponseData responseData = new ResponseData();
            responseData.setData(inventoryService.getInventory());
            responseData.setSuccess(true);
            responseData.setDesc("");
            responseData.setStatus(HttpStatus.OK.value());
            return new ResponseEntity<>(responseData, HttpStatus.OK);
             }

             @GetMapping("/revenue-by-category")
        public ResponseEntity<?> getRevenueByCategory() {
                 ResponseData responseData = new ResponseData();
                 responseData.setData(orderDetailRepositoty.getRevenueByCategory());
                 responseData.setSuccess(true);
                 responseData.setDesc("");
                 responseData.setStatus(HttpStatus.OK.value());
                 return new ResponseEntity<>(responseData, HttpStatus.OK);
             }

             @GetMapping("/revenue-by-year")
        public ResponseEntity<?> getRevenueByYear() {
                ResponseData responseData = new ResponseData();
                responseData.setData(orderDetailRepositoty.getRevenueByYear());
                responseData.setSuccess(true);
                responseData.setDesc("");
                responseData.setStatus(HttpStatus.OK.value());
                return new ResponseEntity<>(responseData, HttpStatus.OK);
        }

        @GetMapping("/revenue-by-quarter")
        public  ResponseEntity<?> getRevenueByQuarter() {
                ResponseData responseData = new ResponseData();
                responseData.setData(orderDetailRepositoty.getRevenueByQuarter());
                responseData.setSuccess(true);
                responseData.setDesc("");
                responseData.setStatus(HttpStatus.OK.value());
                return new ResponseEntity<>(responseData, HttpStatus.OK);
        }

        @GetMapping("/revenue-by-month")
        public  ResponseEntity<?> getRevenueByMonth() {
            ResponseData responseData = new ResponseData();
            responseData.setData(orderDetailRepositoty.getRevenueByMonth());
            responseData.setSuccess(true);
            responseData.setDesc("");
            responseData.setStatus(HttpStatus.OK.value());
            return new ResponseEntity<>(responseData, HttpStatus.OK);
        }
}
