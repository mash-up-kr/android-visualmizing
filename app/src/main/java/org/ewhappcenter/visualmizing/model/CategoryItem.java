package org.ewhappcenter.visualmizing.model;

/**
 * Created by Dong on 2016-02-28.
 */
public class CategoryItem {
    String name;
    int resId;
    boolean selected;

    public CategoryItem(String name, int resId, boolean selected) {
        this.name = name;
        this.resId = resId;
        this.selected = selected;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
}
