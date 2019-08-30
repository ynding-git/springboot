package com.ynding.springboot.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@ApiModel(value = "Role", description = "角色")
public class Role {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @ApiModelProperty(name = "id", notes = "ID", dataType = "long")
    private long id;

    private String name;

    private String nameZh;

    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinTable(name = "hr_role",
            joinColumns = @JoinColumn(name = "rid"),
            inverseJoinColumns = @JoinColumn(name = "hrid"))
    private List<Hr> hrs;

    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinTable(name = "menu_role",
            joinColumns = @JoinColumn(name = "rid"),
            inverseJoinColumns = @JoinColumn(name = "mid"))
    private List<Menu> menus;
}
