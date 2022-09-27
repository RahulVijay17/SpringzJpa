package com.example.SpringJpa.serviceImpl;

import com.example.SpringJpa.dto.OfficeDto;
import com.example.SpringJpa.mapper.OfficeMapper;
import com.example.SpringJpa.model.Office;
import com.example.SpringJpa.repository.OfficeRepository;
import com.example.SpringJpa.service.OfficeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OfficeServiceImpl implements OfficeService {

    Logger logger = LoggerFactory.getLogger(OfficeServiceImpl.class);

    @Autowired
    OfficeRepository officeRepository;


    @Override
    public OfficeDto addOffice(OfficeDto officeDto) {
        logger.info("ADD office Impl");

        try{
            Office office = OfficeMapper.OFFICE_MAPPER.office(officeDto);
            Office office1 =  officeRepository.save(office);

            return OfficeMapper.OFFICE_MAPPER.officeDto(office1);
        }
        catch(Exception e){
            logger.error("Not Created"+e);
            return officeDto;
        }
    }

    @Override
    public List<OfficeDto> getAllOffice() {
        logger.info("GetAll office Impl");

        List<OfficeDto> officeDto = new ArrayList<>();
        try {
            List<Office> officeList=officeRepository.findAll();
            return OfficeMapper.OFFICE_MAPPER.officeDtoList(officeList);
        } catch (Exception e) {
            logger.error("No Id" + e);
            return officeDto;
        }
    }

    @Override
    public List<Office> addEmployee(List<Office> offices) {
        offices=officeRepository.saveAll(offices);
        return offices;
    }
}
