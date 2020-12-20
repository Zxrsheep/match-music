package com.favorite.entity;


import com.favorite.utils.Entity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

@ApiModel(value = "FavoriteMusic 对象", description = "收藏夹音乐实体类(不需要输入时间)")
public class FavoriteMusic extends Entity {

    @ApiModelProperty(value = "对应的收藏夹id",name = "favorite_id")
    private int favorite_id;

    @ApiModelProperty(value = "对应的音乐id",name = "music_id")
    private int music_id;

    @ApiModelProperty(value = "音乐收藏时间",name = "date")
    private Date date;

    public int getFavorite_id() {
        return favorite_id;
    }

    public void setFavorite_id(int favorite_id) {
        this.favorite_id = favorite_id;
    }

    public int getMusic_id() {
        return music_id;
    }

    public void setMusic_id(int music_id) {
        this.music_id = music_id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
