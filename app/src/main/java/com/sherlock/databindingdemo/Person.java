package com.sherlock.databindingdemo;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.ObservableBoolean;

/**
 * Description:   
 * author         xulei
 * Date           2017/2/15 16:16
 */

public class Person extends BaseObservable {
    private String name;
    private String sex;
    public ObservableBoolean isFired;
    public String avator;

    public Person(String name, String sex, boolean isFired) {
        this.name = name;
        this.sex = sex;
        this.isFired = new ObservableBoolean();
        this.isFired.set(isFired);
    }

    public Person(String name, String sex) {
        this.name = name;
        this.sex = sex;
        this.isFired = new ObservableBoolean();
        this.isFired.set(false);
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

    @Bindable
    public ObservableBoolean getIsFired() {
        return isFired;
    }

    public void setIsFired(boolean isFired) {
        this.isFired.set(isFired);
    }

    @Bindable
    public String getAvator() {
        return avator;
    }

    public void setAvator(String avator) {
        this.avator = avator;
    }
}
