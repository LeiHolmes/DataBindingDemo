package com.sherlock.databindingdemo.custom;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.sherlock.databindingdemo.Person;
import com.sherlock.databindingdemo.R;
import com.sherlock.databindingdemo.databinding.ActivityCustomBinding;

public class CustomActivity extends AppCompatActivity {
    private ActivityCustomBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_custom);
        Person person = new Person("xulei", "男");
        person.setAvator("https://avatars3.githubusercontent.com/u/15856028?v=3&s=460");
        binding.setPerson(person);
    }
}
