package net.kaunghtetlin.sfc.network;

import com.google.gson.Gson;

import net.kaunghtetlin.sfc.events.RestApiEvent;
import net.kaunghtetlin.sfc.network.responses.GetNewsResponse;

import org.greenrobot.eventbus.EventBus;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Kaung Htet Lin on 12/3/2017.
 */

public class MMNewsDataAgentImpl implements MMNewsDataAgent {

    private static MMNewsDataAgentImpl objInstance;
    private MMNewsAPI theAPI;

    public static MMNewsDataAgentImpl getInstance() {
        if (objInstance == null) {
            objInstance = new MMNewsDataAgentImpl();
        }
        return objInstance;
    }

    private MMNewsDataAgentImpl() {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .build();


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://padcmyanmar.com/padc-3/mm-news/apis/")
                .addConverterFactory(GsonConverterFactory.create(new Gson())) //convert json into object format
                .client(okHttpClient)
                .build();

        theAPI = retrofit.create(MMNewsAPI.class);
    }

    @Override
    public void loadMMNews(String accessToken, int pageNo) {
        Call<GetNewsResponse> loadMMNewsCall = theAPI.loadMMNews(pageNo, accessToken);
        loadMMNewsCall.enqueue(new Callback<GetNewsResponse>() {
            @Override
            public void onResponse(Call<GetNewsResponse> call, Response<GetNewsResponse> response) {
                GetNewsResponse getNewsResponse = response.body();
                if (getNewsResponse != null && getNewsResponse.getNewsList().size() > 0) {
                    RestApiEvent.NewsDataLoadedEvent newDataLoadedEvent = new RestApiEvent.NewsDataLoadedEvent(
                            getNewsResponse.getPageNo(), getNewsResponse.getNewsList());

                    EventBus.getDefault().post(newDataLoadedEvent);

                } else {
                    RestApiEvent.ErrorInvokingAPIEvent errorEvent
                            = new RestApiEvent.ErrorInvokingAPIEvent("No data could be loaded for now.please try again later");
                    EventBus.getDefault().post(errorEvent);
                }
            }

            @Override
            public void onFailure(Call<GetNewsResponse> call, Throwable t) {
                RestApiEvent.ErrorInvokingAPIEvent errorEvent = new RestApiEvent.ErrorInvokingAPIEvent(t.getMessage());
                EventBus.getDefault().post(errorEvent);
            }
        });
    }

}
