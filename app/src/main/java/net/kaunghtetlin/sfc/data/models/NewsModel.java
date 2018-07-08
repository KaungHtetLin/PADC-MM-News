package net.kaunghtetlin.sfc.data.models;

import net.kaunghtetlin.sfc.data.vo.NewsVO;
import net.kaunghtetlin.sfc.events.RestApiEvent;
import net.kaunghtetlin.sfc.network.MMNewsDataAgentImpl;
import net.kaunghtetlin.sfc.utils.AppConstants;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kaung Htet Lin on 12/3/2017.
 */

public class NewsModel {

    private static NewsModel objInstance;

    private int mmNewsPageIndex = 1;
    private List<NewsVO> mNews;

    private NewsModel() {
        EventBus.getDefault().register(this);
        mNews = new ArrayList<>();
    }

    public static NewsModel getInstance() {
        if (objInstance == null) {
            objInstance = new NewsModel();
        }
        return objInstance;
    }

    public void startLoadingMMNews() {
        MMNewsDataAgentImpl.getInstance().loadMMNews(AppConstants.ACCESS_TOKEN, mmNewsPageIndex);
    }

    @Subscribe
    public void onNewsDataLoaded(RestApiEvent.NewsDataLoadedEvent event) {
        mNews.addAll(event.getLoadNews());
        mmNewsPageIndex = event.getLoadedPageIndex() + 1;
    }
}
