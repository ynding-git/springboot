package com.ynding.springboot.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.omg.CORBA.ServerRequest;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@ApiModel(value = "Role", description = "角色")
public class Role implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @ApiModelProperty(name = "id", notes = "ID", dataType = "long")
    private long id;

    private String name;

    @ApiModelProperty(name = "nameZh", notes = "角色名称", dataType = "string")
    private String nameZh;

    //懒加载 不会查询role表
    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "rid"),
            inverseJoinColumns = @JoinColumn(name = "userid"))
    private List<User> users;

    //急加载 会查询role表
    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinTable(name = "menu_role",
            joinColumns = @JoinColumn(name = "rid"),
            inverseJoinColumns = @JoinColumn(name = "mid"))
    private List<Menu> menus;
}
