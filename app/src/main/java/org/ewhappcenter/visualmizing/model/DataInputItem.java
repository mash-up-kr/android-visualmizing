package org.ewhappcenter.visualmizing.model;

/**
 * Created by Dong on 2016-02-28.
 */
public class DataInputItem {

    String key;
    Float value;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Float getValue() {
        return value;
    }

    public void setValue(Float value) {
        this.value = value;
    }

    public DataInputItem(String key, Float value) {
        this.key = key;
        this.value = value;
    }

    public DataInputItem() {
        this.key = null;
        this.value = null;
    }
}
