package org.ewhappcenter.visualmizing.model;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Dong on 2016-01-31.
 */
/*
 데이터 시각화할 정보를 담은 클래스
 */
public class DataVisualizationItem {
    int chartId;  //그래프 종류

    //디자인 종류
    int designId;
    int singleColorId;  //단색
    int patternId;  //무늬

    //데이터 표시 정보
    boolean isLabel;  //레이블 표시여부
    int textSize;  //글꼴 크기
    int textStyle;  //글꼴 스타일, bold 등..

    //시각화할 데이터
    ArrayList<HashMap<String, Double>> dataList;

    public DataVisualizationItem() {
        this.chartId = -1;
        this.designId = -1;
        this.singleColorId = -1;
        this.patternId = -1;
        this.isLabel = false;
        this.textSize = -1;
        this.textStyle = -1;
        this.dataList = null;
    }

    public DataVisualizationItem(int chartId, int designId, int singleColorId, int patternId, boolean isLabel, int textSize, int textStyle, ArrayList<HashMap<String, Double>> dataList) {
        this.chartId = chartId;
        this.designId = designId;
        this.singleColorId = singleColorId;
        this.patternId = patternId;
        this.isLabel = isLabel;
        this.textSize = textSize;
        this.textStyle = textStyle;
        this.dataList = dataList;
    }

    public int getChartId() {

        return chartId;
    }

    public void setChartId(int chartId) {
        this.chartId = chartId;
    }

    public int getDesignId() {
        return designId;
    }

    public void setDesignId(int designId) {
        this.designId = designId;
    }

    public int getSingleColorId() {
        return singleColorId;
    }

    public void setSingleColorId(int singleColorId) {
        this.singleColorId = singleColorId;
    }

    public int getPatternId() {
        return patternId;
    }

    public void setPatternId(int patternId) {
        this.patternId = patternId;
    }

    public boolean isLabel() {
        return isLabel;
    }

    public void setIsLabel(boolean isLabel) {
        this.isLabel = isLabel;
    }

    public int getTextSize() {
        return textSize;
    }

    public void setTextSize(int textSize) {
        this.textSize = textSize;
    }

    public int getTextStyle() {
        return textStyle;
    }

    public void setTextStyle(int textStyle) {
        this.textStyle = textStyle;
    }

    public ArrayList<HashMap<String, Double>> getDataList() {
        return dataList;
    }

    public void setDataList(ArrayList<HashMap<String, Double>> dataList) {
        this.dataList = dataList;
    }
}
