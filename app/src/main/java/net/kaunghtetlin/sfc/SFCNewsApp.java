package net.kaunghtetlin.sfc;

import android.app.Application;

import net.kaunghtetlin.sfc.data.models.NewsModel;

/**
 * Created by Kaung Htet Lin on 11/4/2017.
 */

public class SFCNewsApp extends Application {

    public static final String LOG_TAG="SFCNewsApp";

    @Override
    public void onCreate() {
        super.onCreate();
        NewsModel.getInstance().startLoadingMMNews();
    }
}
