package com.api.report.api.service;

import com.api.report.api.repository.MunicipalityRepository;
import com.api.report.api.model.MunicipalityEntityDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MunicipalityService {
    @Autowired
    private MunicipalityRepository municipalityRepository;

    public List<MunicipalityEntityDto> findAll() {
        List<MunicipalityEntityDto> list = new ArrayList<>();
        list = municipalityRepository.searchMunicipalityList();
        return list;
    }

    public MunicipalityEntityDto findByRegion(String Region) {
        MunicipalityEntityDto dto = municipalityRepository.searchMunicipalityItem(Region);
        return dto;
    }

    public MunicipalityEntityDto updateMunicipality(MunicipalityEntityDto updateDto) {
        municipalityRepository.updateItem(updateDto);
        return updateDto;
    }

    public List<String> searchListAndSort(int count) {
        List<String> list = municipalityRepository.searchRegionList(count);
        return list;
    }
    public String searchMinRate(){
        return municipalityRepository.searchMinRate();
    }
    public boolean insertMunicipality(List<MunicipalityEntityDto> list){
        try {
            for (MunicipalityEntityDto dto : list) {
                municipalityRepository.insertItem(dto);
            }
        }
        catch (Exception e){
            return false;
        }
        return true;
    }


}
