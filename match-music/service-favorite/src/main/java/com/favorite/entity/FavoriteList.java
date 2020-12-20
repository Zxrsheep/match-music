package com.favorite.entity;


import com.favorite.utils.Entity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "FavoriteList 对象", description = "收藏夹实体类")
public class FavoriteList extends Entity {
    @ApiModelProperty(value = "收藏夹主键id，PK UN AI",name = "id")
    private int id;

    @ApiModelProperty(value = "收藏夹对应用户id，UN",name = "user_id")
    private int user_id;

    @ApiModelProperty(value = "收藏夹名称",name = "name")
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
