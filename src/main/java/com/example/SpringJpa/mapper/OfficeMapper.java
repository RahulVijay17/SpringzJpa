package com.example.SpringJpa.mapper;


import com.example.SpringJpa.dto.OfficeDto;
import com.example.SpringJpa.model.Office;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface OfficeMapper {

    OfficeMapper OFFICE_MAPPER = Mappers.getMapper(OfficeMapper.class);

    OfficeDto officeDto(Office office);

    Office office(OfficeDto officeDto);

    List<OfficeDto> officeDtoList(List<Office>  officeList);

    List<Office> officeList(List<OfficeDto> officeDtoList);

}
