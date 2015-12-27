package org.ewhappcenter.visualmizing;

import java.util.Date;

/**
 * Created by Dong on 2015-12-27.
 */
public class MyDataVisualizationListItem {

    String title;
    Integer categoryCode;
    Integer imgDataVisualization;
    Boolean bookmark;  //사라질 듯
    Integer likeCount;  //사라질 듯
    String userName;  //사라질 듯
    Date createAt;

    public MyDataVisualizationListItem() {}

    public MyDataVisualizationListItem(String title, Integer categoryCode, Integer imgDataVisualization, Boolean bookmark, Integer likeCount, String userName, Date createAt) {
        this.title = title;
        this.categoryCode = categoryCode;
        this.imgDataVisualization = imgDataVisualization;
        this.bookmark = bookmark;
        this.likeCount = likeCount;
        this.userName = userName;
        this.createAt = createAt;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(Integer categoryCode) {
        this.categoryCode = categoryCode;
    }

    public Integer getImgDataVisualization() {
        return imgDataVisualization;
    }

    public void setImgDataVisualization(Integer imgDataVisualization) {
        this.imgDataVisualization = imgDataVisualization;
    }

    public Boolean getBookmark() {
        return bookmark;
    }

    public void setBookmark(Boolean bookmark) {
        this.bookmark = bookmark;
    }

    public Integer getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(Integer likeCount) {
        this.likeCount = likeCount;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }
}
