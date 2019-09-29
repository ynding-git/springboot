package com.ynding.springboot.web.data;

import com.ynding.springboot.entity.Book;
import com.ynding.springboot.entity.Menu;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

@CacheConfig(cacheNames = "menus")
public interface MenuRepository extends JpaRepository<Menu, Long>,JpaSpecificationExecutor<Book> {

     @Cacheable
     List<Menu> findAll();
}
