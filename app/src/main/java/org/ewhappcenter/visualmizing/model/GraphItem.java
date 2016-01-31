package org.ewhappcenter.visualmizing.model;

/**
 * Created by Dong on 2016-01-31.
 */
public class GraphItem {
    String name;
    int resId;
    boolean selected;

    public GraphItem(String name, int resId, boolean selected) {
        this.name = name;
        this.resId = resId;
        this.selected = selected;
    }

        public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
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
}
