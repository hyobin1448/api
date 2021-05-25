package com.api.report.api.dao;

import com.api.report.api.model.UserDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserDto, String> {
}
