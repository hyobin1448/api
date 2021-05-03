package com.api.report.api.service;

import com.api.report.api.dao.MunicipalityRepository;
import com.api.report.api.model.MunicipalityDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MunicipalityService {
    @Autowired
    private MunicipalityRepository municipalityRepository;

    public List<MunicipalityDto> findAll(){
        List<MunicipalityDto> list = new ArrayList<>();
        municipalityRepository.findAll().forEach(e->list.add(e));
        return list;
    }
}
