package com.jiapt.recyclerviewtest.bean;

/**
 * Created by jiapt on 2018/3/22.
 * <p>
 * description:
 */

public class DataBean {
    private String text;  //item的显示内容
    private boolean isSelected;  //item是否选中的标签

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        this.isSelected = selected;
    }
}
