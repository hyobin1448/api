package com.api.report.api.dao;

import com.api.report.api.model.MunicipalityDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MunicipalityRepository extends JpaRepository<MunicipalityDto,String> {
    Optional<MunicipalityDto> findByRegion(String region);
    List<MunicipalityDto> findAll();

}
