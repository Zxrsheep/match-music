package com.like.entity;

import com.like.utils.Entity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "Like 对象", description = "维护点赞(like)信息")
public class Like extends Entity {

    @ApiModelProperty(value = "收藏夹对应用户id，UN",name = "user_id")
    private int user_id;

    @ApiModelProperty(value = "对应的音乐id",name = "music_id")
    private int music_id;

    @ApiModelProperty(value = "收藏夹对应用户id，UN",name = "status")
    private int status;

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getMusic_id() {
        return music_id;
    }

    public void setMusic_id(int music_id) {
        this.music_id = music_id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
