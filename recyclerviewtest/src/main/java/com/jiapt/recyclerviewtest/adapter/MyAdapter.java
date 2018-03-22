package com.jiapt.recyclerviewtest.adapter;

import android.graphics.Color;
import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jiapt.recyclerviewtest.R;
import com.jiapt.recyclerviewtest.bean.DataBean;

import java.util.List;

/**
 * Created by jiapt on 2018/3/17.
 * <p>
 * description:
 */

public class MyAdapter extends BaseQuickAdapter<DataBean, BaseViewHolder> {
    public MyAdapter(int layoutResId, @Nullable List<DataBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, DataBean item) {

        //根据刷新后的数据判断item显示什么颜色的背景
        if (item.isSelected()) {
            helper.setText(R.id.tv_item, item.getText()).getView(R.id.tv_item).setBackgroundColor(Color.RED);
        } else {
            helper.setText(R.id.tv_item, item.getText()).getView(R.id.tv_item).setBackgroundColor(Color.parseColor("#fffaaa"));
        }
    }
}
