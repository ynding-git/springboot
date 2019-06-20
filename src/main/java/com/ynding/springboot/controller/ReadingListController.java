package com.ynding.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ynding.springboot.data.jpa.ReadingListRepository;

/**
 * @author ynding
 *
 */
@RestController
@RequestMapping("/readingList")
public class ReadingListController {

	private ReadingListRepository readingListRepository;

	@Autowired
	public ReadingListController(ReadingListRepository readingListRepository) {
		this.readingListRepository = readingListRepository;
	}
	
	
}
