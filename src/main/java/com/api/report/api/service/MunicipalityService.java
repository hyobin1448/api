package com.api.report.api.service;

import com.api.report.api.dao.MunicipalityRepository;
import com.api.report.api.model.MunicipalityDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.JpaSort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MunicipalityService {
    @Autowired
    private MunicipalityRepository municipalityRepository;

    public List<MunicipalityDto> findAll(){
        List<MunicipalityDto> list = new ArrayList<>();
        municipalityRepository.findAll().forEach(e->list.add(e));
        return list;
    }
    public MunicipalityDto findByRegion(String Region){
        Optional<MunicipalityDto> dto = municipalityRepository.findById(Region);
        return dto.get();
    }

    public MunicipalityDto updateMunicipality(MunicipalityDto updateDto){
        Optional<MunicipalityDto> dto = municipalityRepository.findById(updateDto.getRegion());
        dto.ifPresent(selectUser->{
            selectUser.setInstitute(updateDto.getInstitute());
            selectUser.setLimit(updateDto.getLimit());
            selectUser.setMgmt(updateDto.getMgmt());
            selectUser.setRate(updateDto.getRate());
            selectUser.setUsage(updateDto.getUsage());
            selectUser.setReception(updateDto.getReception());
            selectUser.setTarget(updateDto.getTarget());
            municipalityRepository.save(selectUser);
        });
        return dto.get();
    }
    public List<String> searchListAndSort(int count){
        List<String> list = new ArrayList<>();
        municipalityRepository.findByRegionList(PageRequest.of(0,count))
                .forEach(e->list.add(e));
        return list;
    }
}
