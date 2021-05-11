package com.api.report.api.dao;

import com.api.report.api.model.MunicipalityDto;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MunicipalityRepository extends JpaRepository<MunicipalityDto,String> {
    Optional<MunicipalityDto> findByRegion(String region);
    List<MunicipalityDto> findAll();
    @Query("SELECT region FROM municipality " +
            "ORDER BY REPLACE(REPLACE(REPLACE(application_limit,' ',''),'억원이내','000000000'),'백만원이내','0000000') * 1  DESC, (SUBSTRING_INDEX(rate,'~',-1)+SUBSTRING_INDEX(rate,'~',1))/2")
    List<String> findByRegionList(Pageable pageable);

}
