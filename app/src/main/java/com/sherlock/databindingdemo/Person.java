package com.sherlock.databindingdemo;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.ObservableBoolean;

/**
 * Created by e-eduspace01 on 2017/2/15.
 */

public class Person extends BaseObservable {
    private String name;
    private String sex;
    public ObservableBoolean isShow;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }

    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(com.sherlock.databindingdemo.BR.name);
        notifyChange();
    }

    @Bindable
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
//        notifyChange();
    }

    public Person(String name, String sex) {
        this.name = name;
        this.sex = sex;
        isShow = new ObservableBoolean();
        isShow.set(false);
    }

    @Bindable
    public ObservableBoolean getIsShow() {
        return isShow;
    }

    public void setIsShow(boolean isshow) {
        isShow.set(isshow);
    }
}
