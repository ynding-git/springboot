package com.ynding.springboot.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@ApiModel(value = "Book", description = "书籍")
public class Book {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@ApiModelProperty(name = "id", notes = "ID", dataType = "long")
	private Long id;

	@ApiModelProperty(name = "reader", notes = "读者", dataType = "string")
	private String reader;

	@ApiModelProperty(name = "isbn", notes = "isbn", dataType = "string")
	private String isbn;

	@ApiModelProperty(name = "title", notes = "标题", dataType = "string")
	private String title;

	@ApiModelProperty(name = "author", notes = "作者", dataType = "string")
	private String author;

	@ApiModelProperty(name = "description", notes = "描述", dataType = "string")
	private String description;

}
