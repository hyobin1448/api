package com.api.report.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Data // 자동 getter, setter
public class MunicipalityEntityDto implements PublicDto {
    @JsonIgnore
    private String id;
    private String region;
    private String target;
    private String usage;
    private String limit;
    private String rate;
    private String institute;
    private String mgmt;
    private String reception;
}
