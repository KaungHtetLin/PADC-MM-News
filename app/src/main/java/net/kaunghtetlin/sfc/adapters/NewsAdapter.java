package net.kaunghtetlin.sfc.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.kaunghtetlin.sfc.R;
import net.kaunghtetlin.sfc.viewholders.NewsViewHolder;

/**
 * Created by Kaung Htet Lin on 11/4/2017.
 */

public class NewsAdapter extends RecyclerView.Adapter<NewsViewHolder> {

    private LayoutInflater mlayoutInflater;

    public NewsAdapter(Context context) {
        mlayoutInflater =LayoutInflater.from(context);
    }

    @Override
    public NewsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View newsItemView=mlayoutInflater.inflate(R.layout.view_item_news,parent,false);
        return new NewsViewHolder(newsItemView);
    }

    @Override
    public void onBindViewHolder(NewsViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 16;
    }
}
