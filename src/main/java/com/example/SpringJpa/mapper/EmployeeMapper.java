package com.example.SpringJpa.mapper;


import com.example.SpringJpa.dto.EmployeeDto;
import com.example.SpringJpa.model.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface EmployeeMapper {

    EmployeeMapper EMPLOYEE_MAPPER = Mappers.getMapper(EmployeeMapper.class);

    EmployeeDto employeeDto(Employee employee);

    Employee employee(EmployeeDto employeeDto);

    List<EmployeeDto> employeeDtoList(List<Employee>  employeeList);

    List<Employee> employeeList(List<EmployeeDto> employeeDtoList);

}
