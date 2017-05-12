package com.sherlock.databindingdemo.lambda;

import android.app.Activity;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.widget.Toast;

import com.sherlock.databindingdemo.Person;
import com.sherlock.databindingdemo.R;
import com.sherlock.databindingdemo.databinding.ActivityLambdaBinding;

public class LambdaActivity extends Activity {
    private ActivityLambdaBinding binding;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_lambda);
        binding.setPerson(new Person("xulei", "man"));
        binding.setPresenter(new Presenter());
    }

    public class Presenter {
        public void onPersonClick(Person person) {
            Toast.makeText(LambdaActivity.this, "onPersonClick", Toast.LENGTH_SHORT).show();
        }

        public void onPersonLongClick(Person person, Context context) {
            Toast.makeText(LambdaActivity.this, "onPersonLongClick", Toast.LENGTH_SHORT).show();
        }

        public void onFocusChange(Person person) {
            Toast.makeText(LambdaActivity.this, "onFocusChange", Toast.LENGTH_SHORT).show();
        }
    }
}
