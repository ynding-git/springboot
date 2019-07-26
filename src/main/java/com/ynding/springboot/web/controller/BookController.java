package com.ynding.springboot.web.controller;

import com.ynding.springboot.web.data.BookRepository;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ynding
 *
 */
@Slf4j
@RestController
@RequestMapping("/book")
@Api(value="Book",tags={"Book-Controller"})
public class BookController {

	private final BookRepository bookRepository;

	@Autowired
	public BookController(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}



	
}
