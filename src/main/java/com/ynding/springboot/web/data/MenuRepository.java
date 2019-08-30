package com.ynding.springboot.web.data;

import com.ynding.springboot.entity.Hr;
import com.ynding.springboot.entity.Menu;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@CacheConfig(cacheNames = "menus")
public interface MenuRepository extends JpaRepository<Menu, Long> {

     @Cacheable
     List<Menu> findAll();
}
