package com.api.report.api;

import com.api.report.api.dao.MunicipalityRepository;
import com.api.report.api.model.MunicipalityDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class ApiApplicationTests {
    @Autowired
    private MunicipalityRepository municipalityRepository;
    @Test
    void contextLoads() {
        List<MunicipalityDto> list = municipalityRepository.findAll();
        System.out.println("test"+list.toString());
    }
    @Test
    void getRegion(){
        MunicipalityDto dto = municipalityRepository.findByRegion("강릉시");
        assertEquals("강릉시",dto.getRegion());
        assertEquals("강릉시 소재 중소기업으로서 강릉시장이 추천한 자",dto.getTarget());
        assertEquals("운전",dto.getUsage());
        assertEquals("추천금액 이내",dto.getLimit());
        assertEquals("3.00%",dto.getRate());
        assertEquals("강릉시",dto.getInstitute());
        assertEquals("강릉지점",dto.getMgmt());
        assertEquals("강릉시 소재 영업점",dto.getReception());
    }

}
