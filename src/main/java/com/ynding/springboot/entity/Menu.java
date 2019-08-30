package com.ynding.springboot.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@ApiModel(value = "Menu", description = "菜单")
public class Menu {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @ApiModelProperty(name = "id", notes = "ID", dataType = "long")
    private long id;

    private String url;
    private String path;
    private String component;
    private String name;
    private String iconCls;
    private Enum keepAlive;
    private Enum requireAuth;
    private Integer parentId;
    private Enum enabled;

    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinTable(name = "menu_role",
            joinColumns = @JoinColumn(name = "mid"),
            inverseJoinColumns = @JoinColumn(name = "rid"))
    private List<Role> roles;
}
