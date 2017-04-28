package com.sherlock.databindingdemo.setter;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.View;

import com.sherlock.databindingdemo.Person;
import com.sherlock.databindingdemo.R;
import com.sherlock.databindingdemo.databinding.ActivitySetterBinding;

import java.util.Random;

public class SetterActivity extends Activity {
    private ActivitySetterBinding binding;
    private Random random = new Random(System.currentTimeMillis());
    private Person person;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_setter);
        person = new Person("xulei", "男");
        person.setAvator("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1492422326&di=4f57a7515b2e0f339e87d0e4b82ea20b&imgtype=jpg&er=1&src=http%3A%2F%2Fwww.005.tv%2Fuploads%2Fallimg%2F161011%2F142TQ4V-1.jpg");
        binding.setPerson(person);
        binding.setPresenter(new Presenter());
    }

    public class Presenter {
        public void onClick(View view) {
            person.setIsFired(random.nextBoolean());
        }
    }
}
