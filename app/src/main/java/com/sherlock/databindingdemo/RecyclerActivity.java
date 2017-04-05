package com.sherlock.databindingdemo;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.view.Window;
import android.widget.Toast;

import com.sherlock.databindingdemo.databinding.ActivityRecyclerBinding;

import java.util.ArrayList;
import java.util.List;


/**
 * Description:   DataBinding实现RecyclerView数据绑定
 * author         xulei
 * Date           2017/3/17 14:59
 */
public class RecyclerActivity extends Activity {
    private ActivityRecyclerBinding binding;
    private PersonAdapter adapter;
    private List<Person> list;
    private String[] sexArr = {"男", "女"};
    private boolean[] isFiredArr = {true, false};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_recycler);
        initData();
        initListener();
    }

    private void initListener() {
        adapter.setOnItemClickListener(new PersonAdapter.OnItemClickListener() {
            @Override
            public void onClick(View view, Person person, int position) {
                Toast.makeText(RecyclerActivity.this, "点击了" + position + ":" + person.getName(), Toast.LENGTH_SHORT).show();
            }
        });
        binding.setPresenter(new PresenterRecycle());
    }

    private void initData() {
        //初始化RecyclerView
        adapter = new PersonAdapter(this);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        binding.recyclerView.setItemAnimator(new DefaultItemAnimator());
        binding.recyclerView.setAdapter(adapter);
        //制造假数据
        list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add(new Person("xulei" + i, sexArr[(int) (Math.random() * 2)], isFiredArr[(int) (Math.random() * 2)]));
        }
        adapter.setList(list);
    }

    public class PresenterRecycle {
        public void onClickAddItem(View view) {//增加item
            adapter.addItem(new Person("xulei", "男", false));
        }

        public void onClickRemoveItem(View view) {//删除item
            adapter.removeItem();
        }
    }
}
