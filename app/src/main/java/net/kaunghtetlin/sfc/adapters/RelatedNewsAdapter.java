package net.kaunghtetlin.sfc.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.kaunghtetlin.sfc.R;
import net.kaunghtetlin.sfc.data.vo.RelatedNewsVO;
import net.kaunghtetlin.sfc.delegates.NewsItemDelegate;
import net.kaunghtetlin.sfc.viewholders.RelatedNewsViewHolder;

/**
 * Created by Kaung Htet Lin on 11/25/2017.
 */

public class RelatedNewsAdapter extends BaseRecyclerAdapter<RelatedNewsViewHolder,RelatedNewsVO> {

    public RelatedNewsAdapter(Context context) {
        super(context);
    }

    @Override
    public RelatedNewsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View relatedNewsView = mLayoutInflator.inflate(R.layout.view_item_related_news, parent, false);
        return new RelatedNewsViewHolder(relatedNewsView);
    }

    @Override
    public void onBindViewHolder(RelatedNewsViewHolder holder, int position) {

    }
}
