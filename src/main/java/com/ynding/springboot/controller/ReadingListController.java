package com.ynding.springboot.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ynding.springboot.data.ReadingListRepository;

/**
 * @author ynding
 *
 */
@Slf4j
@RestController
@RequestMapping("/readingList")
public class ReadingListController {

	private final ReadingListRepository readingListRepository;

	@Autowired
	public ReadingListController(ReadingListRepository readingListRepository) {
		this.readingListRepository = readingListRepository;
	}



	
}
