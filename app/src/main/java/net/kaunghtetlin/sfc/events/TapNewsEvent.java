package net.kaunghtetlin.sfc.events;

/**
 * Created by Kaung Htet Lin on 12/2/2017.
 */

public class TapNewsEvent {
    private String newsId;

    public TapNewsEvent(String newsId) {
        this.newsId = newsId;
    }

    public String getNewsId() {
        return newsId;
    }
}
