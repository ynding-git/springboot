package com.ynding.springboot.web.data;

import com.ynding.springboot.entity.Role;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface RoleRepository extends JpaRepository<Role, Long>,JpaSpecificationExecutor<Role> {
    @Cacheable
    List<Role> findAll();
}
