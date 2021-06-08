package com.music.entity;

import com.music.utils.Entity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "Music 对象", description = "首页音乐推荐对象Music")
public class Music extends Entity {
    @ApiModelProperty(value = "音乐主键id，UN AI",name = "id")
    //{"id":1,"name":"xxx"}
    private int id;
    @ApiModelProperty(value = "对应推荐音乐的管理员id",name = "user_id",required = true)
        private int user_id;
    @ApiModelProperty(value = "音乐名",name = "name",required = true)
    private String name;
    @ApiModelProperty(value = "音乐封面路径，使用url",name = "cover_url")
    private String cover_url;
    @ApiModelProperty(value = "歌手姓名",name = "singer_name",required = true)
    private String singer_name;
    @ApiModelProperty(value = "歌手信息描述",name = "singer_name")
    private String singer_info;
    @ApiModelProperty(value = "歌词简要信息，VARCHAR(200)大小",name = "lyric")
    private String lyric;
    @ApiModelProperty(value = "歌手图片(url)",name = "singer_photo")
    private String singer_photo;
    @ApiModelProperty(value = "创作故事，VARCHAR(500)大小",name = "story")
    private String story;
    @ApiModelProperty(value = "播放路径",name = "play_url")
    private String play_url;

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

    public String getCover_url() {
        return cover_url;
    }

    public void setCover_url(String cover_url) {
        this.cover_url = cover_url;
    }

    public String getSinger_name() {
        return singer_name;
    }

    public void setSinger_name(String singer_name) {
        this.singer_name = singer_name;
    }

    public String getSinger_info() {
        return singer_info;
    }

    public void setSinger_info(String singer_info) {
        this.singer_info = singer_info;
    }

    public String getLyric() {
        return lyric;
    }

    public void setLyric(String lyric) {
        this.lyric = lyric;
    }

    public String getSinger_photo() {
        return singer_photo;
    }

    public void setSinger_photo(String singer_photo) {
        this.singer_photo = singer_photo;
    }

    public String getStory() {
        return story;
    }

    public void setStory(String story) {
        this.story = story;
    }

    public String getPlay_url() {
        return play_url;
    }

    public void setPlay_url(String play_url) {
        this.play_url = play_url;
    }
}
