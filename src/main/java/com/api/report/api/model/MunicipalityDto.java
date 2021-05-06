package com.api.report.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Data // 자동 getter, setter
@Entity (name = "municipality")// Table 매핑
public class MunicipalityDto implements PublicDto {
    @Id // PK 설정;
    private String region;
    private String target;
    @Column(name = "purpose_use")
    private String usage;
    @Column(name = "application_limit")
    private String limit;
    private String rate;
    private String institute;
    private String mgmt;
    private String reception;
}
