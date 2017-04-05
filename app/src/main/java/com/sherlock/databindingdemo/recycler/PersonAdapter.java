package com.sherlock.databindingdemo.recycler;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sherlock.databindingdemo.Person;
import com.sherlock.databindingdemo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:   RecyclerView的bindingAdapter
 * author         xulei
 * Date           2017/3/17
 */

public class PersonAdapter extends RecyclerView.Adapter<BindingViewHolder> {
    private static final int ITEM_VIEW_TYPE_FIRED = 1;
    private static final int ITEM_VIEW_TYPE_NOT_FIRED = 2;
    private LayoutInflater inflater;
    private Context context;
    private OnItemClickListener onItemClickListener;
    private List<Person> list;

    public PersonAdapter(Context context) {
        this.context = context;
        inflater = LayoutInflater.from(context);
        list = new ArrayList<>();
    }

    public void setList(List<Person> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public BindingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewDataBinding binding;
        if (viewType == ITEM_VIEW_TYPE_FIRED) {
            binding = DataBindingUtil.inflate(inflater, R.layout.item_is_fired, parent, false);
        } else {
            binding = DataBindingUtil.inflate(inflater, R.layout.item_is_not_fired, parent, false);
        }
        return new BindingViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(BindingViewHolder holder, final int position) {
        final Person person = list.get(position);
        holder.getBinding().setVariable(com.sherlock.databindingdemo.BR.person, person);
        holder.getBinding().executePendingBindings();//需即时刷新数据
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickListener.onClick(v, person, position);
            }
        });
    }

    @Override
    public int getItemViewType(int position) {
        if (list.get(position).getIsFired().get())//根据isfired返回不同类型
            return ITEM_VIEW_TYPE_FIRED;
        else
            return ITEM_VIEW_TYPE_NOT_FIRED;
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    interface OnItemClickListener {
        void onClick(View view, Person person, int position);
    }

    /**
     * 增加item
     */
    public void addItem(Person person) {
        int index = (int) (Math.random() * list.size());
        list.add(index, person);
        notifyItemInserted(index);
    }

    /**
     * 移除item
     */
    public void removeItem() {
        int index = (int) (Math.random() * list.size());
        if (list.size() > index) {
            list.remove(index);
            notifyItemRemoved(index);
        }
    }
}

