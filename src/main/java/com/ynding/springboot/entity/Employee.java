package com.ynding.springboot.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Data
@Entity
@ApiModel(value = "Employee",description = "员工")
public class Employee {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @ApiModelProperty(name = "id", notes = "ID", dataType = "long")
    private long id;

    private String name;
    private String gender;
    private Date birthday;
    private String idCard;
    private String wedlock;
    private long nationId;
    private String nationPlace;
    private long politicId;
    private String email;
    private String phone;
    private String address;
    private long departmentId;
    private long jobLevelId;
    private long posId;
    private String engageForm;
    private String tiptopDegree;
    private String specialty;
    private String school;
    private Date beginDate;
    private String workState;
    private String worked;
    private Float contractTerm;
    private Date conversionTime;
    private Date notWorkDate;
    private Date beginContract;
    private Date endContract;
    private Integer workAge;


}
