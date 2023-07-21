package com.survey.repository;

import com.survey.entity.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<SysUser,Long> {
    SysUser findByUsername(String username);
}
