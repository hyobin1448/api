package com.api.report.api;

import com.api.report.api.repository.MunicipalityRepository;
import com.api.report.api.model.MunicipalityEntityDto;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@MapperScan(basePackageClasses = ApiApplication.class)
public class ApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiApplication.class, args);
    }
}
