package com.soa.entity;

import com.soa.utils.Entity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

@ApiModel(value = "Notice 对象", description = "公告对象Notice")
public class Notice extends Entity {

    @ApiModelProperty(value = "Notice id，唯一，not null，自增",name = "id",required = true)
    private int id;

    @ApiModelProperty(value = "Noticed 的内容",name = "content",required = true)
    private String content;

    @ApiModelProperty(value = "Noticed 的创建时间",name = "date",required = true)
    private Date date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
