package net.kaunghtetlin.sfc.events;

import net.kaunghtetlin.sfc.data.vo.NewsVO;

import java.util.List;

/**
 * Created by Kaung Htet Lin on 12/2/2017.
 */

public class RestApiEvent {
    public static class EmptyResponseEvent {

    }

    public static class ErrorInvokingAPIEvent {
        private String errorMsg;

        public ErrorInvokingAPIEvent(String errorMsg) {
            this.errorMsg = errorMsg;
        }

        public String getErrorMsg() {
            return errorMsg;
        }
    }

    public static class NewsDataLoadedEvent {
        private int loadedPageIndex;
        private List<NewsVO> loadNews;

        public NewsDataLoadedEvent(int loadedPageIndex, List<NewsVO> loadNews) {
            this.loadedPageIndex = loadedPageIndex;
            this.loadNews = loadNews;
        }

        public int getLoadedPageIndex() {
            return loadedPageIndex;
        }

        public List<NewsVO> getLoadNews() {
            return loadNews;
        }
    }
}
