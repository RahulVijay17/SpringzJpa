package com.example.SpringJpa.serviceImpl;

import com.example.SpringJpa.dto.EmployeeDto;
import com.example.SpringJpa.dto.OfficeDto;
import com.example.SpringJpa.mapper.EmployeeMapper;
import com.example.SpringJpa.mapper.OfficeMapper;
import com.example.SpringJpa.model.Employee;
import com.example.SpringJpa.model.Office;
import com.example.SpringJpa.repository.EmployeeRepository;
import com.example.SpringJpa.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    Logger logger = LoggerFactory.getLogger(EmployeeService.class);


    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto addEmployee(EmployeeDto employeeDto) {
        logger.info("ADD employee Impl");

        try {
            Employee employee = EmployeeMapper.EMPLOYEE_MAPPER.employee(employeeDto);
            Employee employee1 = employeeRepository.save(employee);

            return EmployeeMapper.EMPLOYEE_MAPPER.employeeDto(employee1);
        } catch (Exception e) {
            logger.error("Not Created" + e);
            return employeeDto;
        }
    }

    @Override
    public List<EmployeeDto> getAllEmployee() {
        logger.info("GetAll office Impl");

        List<EmployeeDto> employeeDto = new ArrayList<>();
        try {
            List<Employee> employeeList = employeeRepository.findAll();
            return EmployeeMapper.EMPLOYEE_MAPPER.employeeDtoList(employeeList);
        } catch (Exception e) {
            logger.error("No Id" + e);
            return employeeDto;
        }
    }
}
