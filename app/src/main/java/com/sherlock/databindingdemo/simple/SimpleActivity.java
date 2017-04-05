package com.sherlock.databindingdemo.simple;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Toast;

import com.sherlock.databindingdemo.Person;
import com.sherlock.databindingdemo.R;
import com.sherlock.databindingdemo.databinding.ActivitySimpleBinding;


public class SimpleActivity extends Activity {
    private Person person = new Person("ShylockXu", "男", false);
    private ActivitySimpleBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_simple);
        binding.setPerson(person);
//        binding.setVariable(BR.person,person);
        binding.setPresenter(new Presenter());
    }

    public class Presenter {
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            person.setName(s.toString());
            person.setSex(s.toString());
            person.setIsFired(!person.isFired.get());
//            binding.setPerson(person);
        }

        public void onClick(View view) {
            Toast.makeText(SimpleActivity.this, "点击成功", Toast.LENGTH_SHORT).show();
            if (!binding.mainViewstub.isInflated())
                binding.mainViewstub.getViewStub().inflate();
        }

        /**
         * 监听器绑定
         * 可回传参数
         */
        public void onButtonClick(Person person) {
            Toast.makeText(SimpleActivity.this, person.getName(), Toast.LENGTH_SHORT).show();
        }
    }
}
