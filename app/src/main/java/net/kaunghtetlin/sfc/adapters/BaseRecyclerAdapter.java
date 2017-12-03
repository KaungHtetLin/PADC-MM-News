package net.kaunghtetlin.sfc.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;

import net.kaunghtetlin.sfc.viewholders.BaseViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kaung Htet Lin on 12/2/2017.
 */

public abstract class BaseRecyclerAdapter<T extends BaseViewHolder, W> extends RecyclerView.Adapter<T> {

    protected List<W> mData;
    protected LayoutInflater mLayoutInflator;

    public BaseRecyclerAdapter(Context context) {
        mData = new ArrayList<>();
        mLayoutInflator = LayoutInflater.from(context);
    }

    @Override
    public void onBindViewHolder(T holder, int position) {
        holder.setData(mData.get(position));
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }
}
