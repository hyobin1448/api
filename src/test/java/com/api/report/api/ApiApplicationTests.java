package com.api.report.api;

import com.api.report.api.dao.MunicipalityRepository;
import com.api.report.api.model.MunicipalityDto;
import com.api.report.api.service.MunicipalityService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class ApiApplicationTests {
    @Autowired
    private MunicipalityRepository municipalityRepository;
    @Autowired
    private MunicipalityService municipalityService;

    @Test
    void testFindAll(){
        List<MunicipalityDto> list = municipalityService.findAll();
        assertEquals(98,list.size());
    }
    @Test
    void testFindByRegion(){
        MunicipalityDto dto = municipalityService.findByRegion("강릉시");
        assertEquals("강릉시",dto.getRegion());
        assertEquals("강릉시 소재 중소기업으로서 강릉시장이 추천한 자",dto.getTarget());
        assertEquals("운전",dto.getUsage());
        assertEquals("추천금액 이내",dto.getLimit());
        assertEquals("3%",dto.getRate());
        assertEquals("강릉시",dto.getInstitute());
        assertEquals("강릉지점",dto.getMgmt());
        assertEquals("강릉시 소재 영업점",dto.getReception());
    }

    @Test
    void testUpdateMunicipality(){
        MunicipalityDto dto = new MunicipalityDto();
        dto.setRegion("강원도");
        dto.setTarget("강릉시 소재 중소기업으로서 강릉시장이 추천한 자");
        dto.setUsage("운전");
        dto.setLimit("추천금액 이내");
        dto.setRate("3%");
        dto.setInstitute("강릉시");
        dto.setMgmt("강릉지점");
        dto.setReception("강릉시 소재 영업점");

        municipalityService.updateMunicipality(dto);
        MunicipalityDto updateDto = municipalityService.findByRegion(dto.getRegion());

        assertEquals("강릉시 소재 중소기업으로서 강릉시장이 추천한 자",updateDto.getTarget());
        assertEquals("운전",updateDto.getUsage());
        assertEquals("추천금액 이내",updateDto.getLimit());
        assertEquals("3%",updateDto.getRate());
        assertEquals("강릉시",updateDto.getInstitute());
        assertEquals("강릉지점",updateDto.getMgmt());
        assertEquals("강릉시 소재 영업점",updateDto.getReception());
    }
    @Test
    void testFindAllandSort(){
        List<String> list = municipalityService.searchListAndSort(10);
        assertEquals(98,list.size());
    }
}
