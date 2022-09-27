package com.example.SpringJpa.controller;

import com.example.SpringJpa.dto.OfficeDto;
import com.example.SpringJpa.mapper.OfficeMapper;
import com.example.SpringJpa.model.Employee;
import com.example.SpringJpa.model.Office;
import com.example.SpringJpa.service.OfficeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/")
public class OfficeController {

    Logger logger= LoggerFactory.getLogger(OfficeController.class);

    @Autowired
    OfficeService officeService;

    @PostMapping("/office")
    public OfficeDto addOffice(@RequestBody OfficeDto officeDto) {
        logger.info("Adding method");
        try{
            officeDto= officeService.addOffice(officeDto);
            return officeDto;
        }
        catch (Exception e)
        {
            logger.error("null"+e);
            return  officeDto;
        }

    }

    @GetMapping("/office")
    public List<OfficeDto> getAllOffice() {
        List<OfficeDto> officeDtoList = new ArrayList<>();
        try {
            officeDtoList = officeService.getAllOffice();
            return officeDtoList;
        } catch (Exception e) {
            logger.error("not registered");
            return officeDtoList;
        }
    }

    @PostMapping("/employee-offices")
    public ResponseEntity<String> saveEmployee(@RequestBody List<Office> offices) {
        List<Office> officeList=new ArrayList<>();
         officeList = officeService.addEmployee(offices);
        return  ResponseEntity.ok("Data Created");
    }

}
