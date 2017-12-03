package net.kaunghtetlin.sfc.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.kaunghtetlin.sfc.R;
import net.kaunghtetlin.sfc.data.vo.NewsVO;
import net.kaunghtetlin.sfc.delegates.NewsItemDelegate;
import net.kaunghtetlin.sfc.viewholders.NewsViewHolder;

/**
 * Created by Kaung Htet Lin on 11/4/2017.
 */

public class NewsAdapter extends BaseRecyclerAdapter<NewsViewHolder,NewsVO> {

    private NewsItemDelegate mNewsItemDelegeate;

    public NewsAdapter(Context context, NewsItemDelegate newsItemDelegate) {
        super(context);
        mNewsItemDelegeate=newsItemDelegate;
    }

    @Override
    public NewsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View newsItemView=mLayoutInflator.inflate(R.layout.view_item_news,parent,false);
        return new NewsViewHolder(newsItemView,mNewsItemDelegeate);
    }

    @Override
    public void onBindViewHolder(NewsViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 16;
    }
}
