package net.kaunghtetlin.sfc.viewholders;

import android.view.View;

import net.kaunghtetlin.sfc.data.vo.NewsVO;
import net.kaunghtetlin.sfc.delegates.NewsItemDelegate;
import net.kaunghtetlin.sfc.events.RestApiEvent;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by Kaung Htet Lin on 11/4/2017.
 */

public class NewsViewHolder extends BaseViewHolder<NewsVO> {

    private NewsItemDelegate mDelegate;

    public NewsViewHolder(View itemView, NewsItemDelegate newsItemDelegate) {
        super(itemView);
        mDelegate = newsItemDelegate;
    }

    @Override
    public void setData(NewsVO data) {

    }

    @Override
    public void onClick(View view) {
//        mDelegate.onTapNews();
//        EventBus.getDefault().post(new TapNewsEvent("news-id"));
        EventBus.getDefault().post(new RestApiEvent.EmptyResponseEvent());
    }
}
