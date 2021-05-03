package com.api.report.api;

import com.api.report.api.dao.MunicipalityRepository;
import com.api.report.api.model.MunicipalityDto;
import com.api.report.api.model.PublicDto;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiApplication.class, args);
    }
    @Bean
    public CommandLineRunner run(MunicipalityRepository municipalityRepository) throws Exception {
        return (String[] args) -> {
         List<MunicipalityDto> list =  readDataFromCsv("D:/2019경력공채_서버개발_사전과제1_지자체협약지원정보_16년12월현재__최종.csv");
            for (MunicipalityDto dto : list) {
                municipalityRepository.save(dto);
            }
        };
    }
    public List<MunicipalityDto> readDataFromCsv(String filePath) throws IOException, CsvValidationException {
        List<MunicipalityDto> list = new ArrayList<>();
        CSVReader reader = new CSVReader(new InputStreamReader(new FileInputStream(filePath), "euc-kr"));

        String [] nextLine;
        while ((nextLine = reader.readNext()) != null) {   // 2
            if(nextLine[0].equals("구분")) continue;;
            MunicipalityDto dto = new MunicipalityDto();
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
