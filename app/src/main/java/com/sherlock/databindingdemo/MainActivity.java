package com.sherlock.databindingdemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

import com.sherlock.databindingdemo.animation.AnimationActivity;
import com.sherlock.databindingdemo.lambda.LambdaActivity;
import com.sherlock.databindingdemo.setter.SetterActivity;
import com.sherlock.databindingdemo.recycler.RecyclerActivity;
import com.sherlock.databindingdemo.simple.SimpleActivity;
import com.sherlock.databindingdemo.twoway.TwoWayActivity;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
    }

    public void onButtonClick(View view) {
        switch (view.getId()) {
            case R.id.button_simple:
                startActivity(new Intent(this, SimpleActivity.class));//简单实现数据绑定
                break;
            case R.id.button_list:
                startActivity(new Intent(this, RecyclerActivity.class));//RecyclerView实现数据绑定
                break;
            case R.id.button_custom:
                startActivity(new Intent(this, SetterActivity.class));//自定义
                break;
            case R.id.button_two_way:
                startActivity(new Intent(this, TwoWayActivity.class));//双向绑定
                break;
            case R.id.button_lambda:
                startActivity(new Intent(this, LambdaActivity.class));//Lambda表达式
                break;
            case R.id.button_animation:
                startActivity(new Intent(this, AnimationActivity.class));//Lambda表达式
                break;
        }
    }
}
