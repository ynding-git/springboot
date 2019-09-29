package com.ynding.springboot.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@ApiModel(value = "Menu", description = "菜单")
public class Menu implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @ApiModelProperty(name = "id", notes = "ID", dataType = "long")
    private long id;

    private String url;
    private String path;
    private String component;
    private String name;
    private String iconCls;
    private Integer keepAlive;//不能用int，因为可以为空，用int的话，必须设置非空
    private Integer requireAuth;
    private Integer parentId;
    private Integer enabled;

    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinTable(name = "menu_role",
            joinColumns = @JoinColumn(name = "mid"),
            inverseJoinColumns = @JoinColumn(name = "rid"))
    private List<Role> roles;
}
