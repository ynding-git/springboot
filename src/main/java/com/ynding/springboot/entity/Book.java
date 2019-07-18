package com.ynding.springboot.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 书
 * @author ynding
 * @version 2019/06/14
 *
 */
@Data
@Entity
public class Book {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	/**
	 * 读者
	 */
	private String reader;
	/**
	 * 
	 */
	private String isbn;
	/**
	 * 标题
	 */
	private String title;
	/**
	 * 作者
	 */
	private String author;
	/**
	 * 描述
	 */
	private String description;

}
