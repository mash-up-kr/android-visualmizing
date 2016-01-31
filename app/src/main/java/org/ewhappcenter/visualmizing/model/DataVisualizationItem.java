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
    int chart;  //그래프 종류

    //디자인 종류
    int singleColor;  //단색
    int pattern;  //무늬

    //데이터 표시 정보
    boolean isLabel;  //레이블 표시여부
    int textSize;  //글꼴 크기
    int textStyle;  //글꼴 스타일, bold 등..

    //시각화할 데이터
    ArrayList<HashMap<String, Double>> dataList;

    public DataVisualizationItem() {
        this.chart = 0;
        this.singleColor = 0;
        this.pattern = 0;
        this.isLabel = false;
        this.textSize = 0;
        this.textStyle = 0;
        this.dataList = null;
    }

    public DataVisualizationItem(int chart, int singleColor, int pattern, boolean isLabel, int textSize, int textStyle, ArrayList<HashMap<String, Double>> dataList) {
        this.chart = chart;
        this.singleColor = singleColor;
        this.pattern = pattern;
        this.isLabel = isLabel;
        this.textSize = textSize;
        this.textStyle = textStyle;
        this.dataList = dataList;
    }

    public int getChart() {
        return chart;
    }

    public void setChart(int chart) {
        this.chart = chart;
    }

    public int getSingleColor() {
        return singleColor;
    }

    public void setSingleColor(int singleColor) {
        this.singleColor = singleColor;
    }

    public int getPattern() {
        return pattern;
    }

    public void setPattern(int pattern) {
        this.pattern = pattern;
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
