package com.ynding.springboot.web.data;

import com.ynding.springboot.entity.Book;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * BOOK
 * @author ynding
 *
 */
@CacheConfig(cacheNames = "books")//返回的内容将存储于名为books的缓存对象中
public interface BookRepository extends JpaRepository<Book, Long>{

	@Cacheable(value = "books",key = "#p0")//使用函数第一个参数作为缓存的key值
	Book findByTitle(String title);

	@CachePut(value = "books",key = "#result.id")//每次都会调用函数
    Book save(Book book);

	@Cacheable(key = "#a0")
	List<Book> findByReader(String reader);


}
