package com.sherlock.databindingdemo.animation;

import android.databinding.DataBindingUtil;
import android.databinding.OnRebindCallback;
import android.databinding.ViewDataBinding;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.TransitionManager;
import android.view.View;
import android.view.ViewGroup;

import com.sherlock.databindingdemo.R;
import com.sherlock.databindingdemo.databinding.ActivityAnimationBinding;

public class AnimationActivity extends AppCompatActivity {
    private ActivityAnimationBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_animation);
        binding.setPresenter(new Presenter());
        //添加消失动画
        binding.addOnRebindCallback(new OnRebindCallback() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public boolean onPreBind(ViewDataBinding binding) {
                ViewGroup viewGroup = (ViewGroup) binding.getRoot();
                TransitionManager.beginDelayedTransition(viewGroup);
                return true;
            }
        });
    }

    public class Presenter {
        public void onCheckedChanged(View buttonView, boolean isChecked) {
            binding.setIsShowImg(isChecked);
        }
    }
}
