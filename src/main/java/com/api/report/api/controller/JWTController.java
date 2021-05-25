package com.api.report.api.controller;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class JWTController {

    @PostMapping(path = "signup")
    public Map<String,Object> signup(){
        return null;
    }
}
