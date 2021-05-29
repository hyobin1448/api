package com.api.report.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Data // 자동 getter, setter
public class MunicipalityDto implements PublicDto {
    private String regionCode;
    private String regionName;
}
