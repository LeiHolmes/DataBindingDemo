package com.sherlock.databindingdemo;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.view.Window;

import com.sherlock.databindingdemo.databinding.ActivityRecyclerBinding;


/**
 * Description:
 * author         xulei
 * Date           2017/3/17 14:59
 */
public class RecyclerActivity extends Activity {
    private ActivityRecyclerBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_recycler);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        
    }
    public class Presenter{
        public void onClickAddItem(View view){
            
        }
        public void onClickRemoveItem(View view){
            
        }
    }
}
