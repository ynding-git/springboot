package com.ynding.springboot.web.data;

import com.ynding.springboot.entity.Hr;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HrRepository extends JpaRepository<Hr, Long> {

    Hr findHrByUsername(String username);
}
