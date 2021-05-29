//package com.api.report.api.controller;
//
//
//import com.api.report.api.model.UserDto;
//import com.api.report.api.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.HashMap;
//import java.util.Map;
//
//@RestController
//public class UserController {
//    @Autowired
//    private UserService service;
//
//    @PostMapping(path = "/signup")
//    public Map<String, Object> signup(UserDto dto) {
//        Map<String, Object> responseMap = new HashMap<>();
//        int flag = service.insertUser(dto);
//        if (flag>0) {
//            responseMap.put("key", "test");
//        } else {
//            responseMap.put("key", "test");
//        }
//        return responseMap;
//    }
//}
