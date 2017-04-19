package com.sherlock.databindingdemo.twoway;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.sherlock.databindingdemo.BR;

/**
 * Description:
 * author         xulei
 * Date           2017/4/19
 */

public class TwoWayBean extends BaseObservable {
    private String name;
    private String password;

    public TwoWayBean(String name, String password) {
        this.name = name;
        this.password = password;
    }

    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }

    @Bindable
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
        notifyPropertyChanged(BR.password);
    }
}
