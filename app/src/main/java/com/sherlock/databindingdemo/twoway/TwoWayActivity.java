package com.sherlock.databindingdemo.twoway;

import android.app.Activity;
import android.databinding.Bindable;
import android.databinding.DataBindingUtil;
import android.databinding.Observable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.sherlock.databindingdemo.R;
import com.sherlock.databindingdemo.databinding.ActivityTwoWayBinding;

/**
 * Description:   双向绑定Activity
 * 双向绑定只支持带有额外事件的属性：text，checked，year，month，hour，冉婷，progress等
 * author         xulei
 * Date           2017/4/19 17:48
 */
public class TwoWayActivity extends Activity {
    private ActivityTwoWayBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_two_way);
        TwoWayBean twoWayBean = new TwoWayBean("xulei", "123456");
        //监听Model中哪个字段改变了
        twoWayBean.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() {
            @Override
            public void onPropertyChanged(Observable observable, int i) {
                Toast.makeText(TwoWayActivity.this, "" + i, Toast.LENGTH_SHORT).show();
            }
        });
        binding.setTwoWayBean(twoWayBean);
    }
}
