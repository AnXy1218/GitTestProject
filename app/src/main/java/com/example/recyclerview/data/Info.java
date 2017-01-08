package com.example.recyclerview.data;

/**
 * Recyclerview的例子的实体模型
 * Created by Leovo on 2016/12/23.
 */
public class Info {

    private String title;
    private String content;
    private String imgUrl;

    public Info(){

    }

    public Info(String content, String imgUrl, String title) {
        this.content = content;
        this.imgUrl = imgUrl;
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
