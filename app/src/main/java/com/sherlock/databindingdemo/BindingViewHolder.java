package com.sherlock.databindingdemo;

import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;

/**
 * Description:
 * author         xulei
 * Date           2017/3/17
 */

public class BindingViewHolder<T extends ViewDataBinding> extends RecyclerView.ViewHolder {
    private T binding;

    public BindingViewHolder(T binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public T getBinding() {
        return binding;
    }
}
