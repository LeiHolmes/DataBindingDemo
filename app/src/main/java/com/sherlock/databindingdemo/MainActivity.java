package com.sherlock.databindingdemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

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
        }
    }
}
