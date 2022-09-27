package com.example.SpringJpa.service;


import com.example.SpringJpa.dto.OfficeDto;
import com.example.SpringJpa.model.Office;

import java.util.List;

public interface OfficeService {
    OfficeDto addOffice(OfficeDto officeDto);

    List<OfficeDto> getAllOffice();

    List<Office> addEmployee(List<Office> offices);
}
