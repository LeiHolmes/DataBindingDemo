package com.sherlock.databindingdemo.recycler;

import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;

/**
 * Description:   数据绑定形式的ViewHolder
 * author         xulei
 * Date           2017/4/1
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
