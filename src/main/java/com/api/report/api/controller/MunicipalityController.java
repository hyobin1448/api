package com.api.report.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class MunicipalityController {
    @GetMapping(path = "/getMunicipalityList")
    public void searchList(){

    }
}
