package com.jiapt.recyclerviewtest;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.jiapt.recyclerviewtest.adapter.MyAdapter;
import com.jiapt.recyclerviewtest.bean.DataBean;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvTest;
    private ArrayList<DataBean> data = new ArrayList<>();
    private int selectedItemPosition = -1;  //界面初始化时的默认值

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvTest = findViewById(R.id.rv_test);
        for (int i = 0; i < 100; i++) {
            DataBean dataBean = new DataBean();
            dataBean.setText("第" + (i + 1) + "条数据");
            data.add(dataBean);
        }

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3);
        rvTest.setLayoutManager(gridLayoutManager);
        final MyAdapter myAdapter = new MyAdapter(R.layout.image_list_item, data);
        rvTest.setAdapter(myAdapter);

        myAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {

                //当之前点击过的图片(初始化界面图片没有被点击过,selectedItemPosition == -1)和当前点击的图片(position)不是同一张图片时,将上一张图片的背景还原
                if (selectedItemPosition != position) {

                    //将当前点击的图片背景设置成红色
                    data.get(position).setSelected(true);  //改变数据
                    myAdapter.notifyItemChanged(position); //刷新数据
//                    myAdapter.notifyDataSetChanged();  也是可以的,不过太浪费

                    //将之前被点击的图片的背景还原
                    if (selectedItemPosition != -1) {
                        data.get(selectedItemPosition).setSelected(false);  //改变数据
                        myAdapter.notifyItemChanged(selectedItemPosition);  //刷新数据
                    }

                    //本次被选中图片的position被记录下来
                    selectedItemPosition = position;
                }
            }
        });
    }
}
