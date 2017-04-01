package com.sherlock.databindingdemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 * author         xulei
 * Date           2017/3/17
 */

public class PersonAdapter extends RecyclerView.Adapter<BindingViewHolder> {
    private static final int ITEM_VIEW_TYPE_ON = 1;
    private static final int ITEM_VIEW_TYPE_OFF = 2;

    private final LayoutInflater mlaLayoutInflater;
    private OnItemClickListener mListener;
    private List<Person> personList;

    public interface OnItemClickListener {
        void onPersonClick(Person person);
    }

    public PersonAdapter(Context context) {
        mlaLayoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        personList = new ArrayList<>();
    }

    @Override
    public int getItemViewType(int position) {
        final Person person = personList.get(position);
        return super.getItemViewType(position);
    }

    @Override
    public BindingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        ViewDataBinding binding
        return null;
    }

    @Override
    public void onBindViewHolder(BindingViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
