package com.api.report.api.controller;

import com.api.report.api.model.MunicipalityEntityDto;
import com.api.report.api.param.MunicipalitParam;
import com.api.report.api.service.MunicipalityService;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class MunicipalityController {
    @Autowired
    private MunicipalityService service;

    @PostMapping(path = "/municipality")
    public Map<String, Object> insertMuniciplity() throws IOException, CsvValidationException {
        List<MunicipalityEntityDto> list = readDataFromCsv("C:/Users/Hyobin/Documents/카카오톡 받은 파일/2019경력공채_서버개발_사전과제1_지자체협약지원정보_16년12월현재__최종.csv");
        boolean flag = service.insertMunicipality(list);
        Map<String,Object> responseMap = new HashMap<>();
        responseMap.put("result",flag?"success":"fail");
        return responseMap;
    }
    @GetMapping(path = "/municipality-list")
    public List<MunicipalityEntityDto> searchList() {
        return service.findAll();
    }

    @GetMapping(path = "/municipality")
    public MunicipalityEntityDto searchMunicipality(MunicipalitParam param) {
        return service.findByRegion(param.getRegion());
    }

    @PutMapping(path = "/municipality")
    public MunicipalityEntityDto updateMunicipality(@RequestBody MunicipalityEntityDto dto) {
        return service.updateMunicipality(dto);
    }

    @GetMapping(path = "/application-limit")
    public List<String> searchListAndSort(int count) {
        return service.searchListAndSort(count);
    }

    @GetMapping(path = "/min-rate")
    public Map<String,Object> searchMinRate(){
        Map<String,Object> responseMap = new HashMap<>();
        String mgmt =service.searchMinRate();
        responseMap.put("mgmt",mgmt);
        return responseMap;
    }

    public List<MunicipalityEntityDto> readDataFromCsv(String filePath) throws IOException, CsvValidationException {
        List<MunicipalityEntityDto> list = new ArrayList<>();
        CSVReader reader = new CSVReader(new InputStreamReader(new FileInputStream(filePath), "euc-kr"));

        String[] nextLine;
        while ((nextLine = reader.readNext()) != null) {   // 2
            MunicipalityEntityDto dto = new MunicipalityEntityDto();
            if(nextLine[0].equals("구분")) continue;;
            dto.setId(nextLine[0]);
            dto.setRegion(nextLine[1]);
            dto.setTarget(nextLine[2]);
            dto.setUsage(nextLine[3]);
            dto.setLimit(nextLine[4]);
            dto.setRate(nextLine[5]);
            dto.setInstitute(nextLine[6]);
            dto.setMgmt(nextLine[7]);
            dto.setReception(nextLine[8]);
            list.add(dto);
        }
        return list;
    }
}
