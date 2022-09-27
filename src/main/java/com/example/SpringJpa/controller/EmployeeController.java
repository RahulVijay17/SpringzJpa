package com.example.SpringJpa.controller;

import com.example.SpringJpa.dto.EmployeeDto;
import com.example.SpringJpa.dto.OfficeDto;
import com.example.SpringJpa.model.Employee;
import com.example.SpringJpa.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/")
public class EmployeeController {

    Logger logger= LoggerFactory.getLogger(EmployeeController.class);
    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/employee")
    public EmployeeDto addStudent(@RequestBody EmployeeDto employeeDto) {
        logger.info("Adding method");
        try{
            employeeDto= employeeService.addEmployee(employeeDto);
            return employeeDto;
        }
        catch (Exception e)
        {
            logger.error("null"+e);
            return  employeeDto;
        }

    }

    @GetMapping("/employee")
    public List<EmployeeDto> getAllEmployee() {
        List<EmployeeDto> employeeDtoList = new ArrayList<>();
        try {
            employeeDtoList = employeeService.getAllEmployee();
            return employeeDtoList;
        } catch (Exception e) {
            logger.error("not registered");
            return employeeDtoList;
        }
    }
}
