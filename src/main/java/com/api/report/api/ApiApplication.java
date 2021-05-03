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

import java.io.*;
import java.util.List;

@SpringBootApplication
public class ApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiApplication.class, args);
    }
    @Bean
    public CommandLineRunner run(MunicipalityRepository municipalityRepository) throws Exception {
        return (String[] args) -> {
          readDataFromCsv("/Users/imhyobin/Downloads/2019경력공채_서버개발_사전과제1_지자체협약지원정보_16년12월현재__최종.csv");
//          municipalityRepository.save(dto);
        };
    }
    public List<PublicDto> readDataFromCsv(String filePath) throws IOException, CsvValidationException {

        CSVReader reader = new CSVReader(new InputStreamReader(new FileInputStream(filePath), "UTF-8"));

        String [] nextLine;
        while ((nextLine = reader.readNext()) != null) {   // 2
            for (int i = 0; i < nextLine.length; i++) {
                System.out.println(i + " " + nextLine[i]);
            }
            System.out.println();
        }
        return null;
    }
}
