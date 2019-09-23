package com.ynding.springboot.web.controller;

import com.ynding.springboot.web.service.BookService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author ynding
 *
 */
@Slf4j
@RestController
@RequestMapping("/book")
@Api(value="Book",tags={"Book-Controller"})
@CrossOrigin(origins = "*")
public class BookController {

	private final BookService bookService;

	@Autowired
	public BookController(BookService bookService) {
		this.bookService = bookService;
	}


}
