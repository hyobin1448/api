package com.api.report.api.controller;

import com.api.report.api.model.MunicipalityDto;
import com.api.report.api.param.MunicipalitParam;
import com.api.report.api.service.MunicipalityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MunicipalityController {
    @Autowired
    private MunicipalityService service;
    @GetMapping(path = "/getMunicipalityList")
    public List<MunicipalityDto> searchList(){
        return service.findAll();
    }
    @GetMapping(path = "/getMunicipality")
    public MunicipalityDto searchMunicipality(MunicipalitParam param){
        return service.findByRegion(param.getRegion());
    }
    @PostMapping(path = "/updateMunicipality")
    public MunicipalityDto updateMunicipality(MunicipalityDto dto){
        return service.updateMunicipality(dto);
    }
    @GetMapping(path = "/searchListAndSort")
    public List<String> searchListAndSort(int count){
        return service.searchListAndSort(count);
    }
}
