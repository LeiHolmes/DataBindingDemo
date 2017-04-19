package com.sherlock.databindingdemo.setter;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;

import com.sherlock.databindingdemo.Person;
import com.sherlock.databindingdemo.R;
import com.sherlock.databindingdemo.databinding.ActivitySetterBinding;

public class SetterActivity extends Activity {
    private ActivitySetterBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_setter);
        Person person = new Person("xulei", "男");
        person.setAvator("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1492422326&di=4f57a7515b2e0f339e87d0e4b82ea20b&imgtype=jpg&er=1&src=http%3A%2F%2Fwww.005.tv%2Fuploads%2Fallimg%2F161011%2F142TQ4V-1.jpg");
        binding.setPerson(person);
    }
}
