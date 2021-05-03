package com.api.report.api;

import com.api.report.api.dao.MunicipalityRepository;
import com.api.report.api.model.MunicipalityDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ApiApplicationTests {
    @Autowired
    private MunicipalityRepository municipalityRepository;
    @Test
    void contextLoads() {
        List<MunicipalityDto> list = municipalityRepository.findAll();
        System.out.println("test"+list.toString());
    }

}
