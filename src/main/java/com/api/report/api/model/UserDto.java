package com.api.report.api.model;

import lombok.Data;

import javax.persistence.Id;

@Data
public class UserDto {
    @Id
    String id;

    String password;
}
