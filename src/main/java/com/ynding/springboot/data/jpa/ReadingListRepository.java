package com.ynding.springboot.data.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ynding.springboot.entity.Book;

/**
 * 仓库
 * @author ynding
 *
 */
public interface ReadingListRepository extends JpaRepository<Book, Long>{

	/**
	 * @param reader
	 * @return
	 */
	List<Book> findByReader(String reader);
}
