package com.api.report.api.repository;

import com.api.report.api.model.MunicipalityDto;
import com.api.report.api.model.MunicipalityEntityDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Mapper
public interface MunicipalityRepository {
//    Optional<MunicipalityEntityDto> findByRegion(String region);
//    List<MunicipalityEntityDto> findAll();
//    @Query("SELECT region FROM municipality " +
//            "ORDER BY REPLACE(REPLACE(REPLACE(application_limit,' ',''),'억원이내','000000000'),'백만원이내','0000000') * 1  DESC, (SUBSTRING_INDEX(rate,'~',-1)+SUBSTRING_INDEX(rate,'~',1))/2")
//    List<String> findByRegionList(Pageable pageable);

    public MunicipalityEntityDto searchMunicipalityItem(String region);

    public List<MunicipalityEntityDto> searchMunicipalityList();

    public List<String> searchRegionList(int count);
    public String searchMinRate();

    public void insertItem(MunicipalityEntityDto dto);
    public void updateItem(MunicipalityEntityDto dto);


}
