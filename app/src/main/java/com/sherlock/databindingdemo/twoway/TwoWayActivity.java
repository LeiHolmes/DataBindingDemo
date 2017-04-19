package com.sherlock.databindingdemo.twoway;

import android.app.Activity;
import android.databinding.Bindable;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.sherlock.databindingdemo.R;
import com.sherlock.databindingdemo.databinding.ActivityTwoWayBinding;
/**
 * Description:   双向绑定Activity
 * author         xulei
 * Date           2017/4/19 17:48
 */
public class TwoWayActivity extends Activity {
    private ActivityTwoWayBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_two_way);
        binding.setTwoWayBean(new TwoWayBean("xulei","123456"));
    }
}
