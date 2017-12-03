package net.kaunghtetlin.sfc.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import net.kaunghtetlin.sfc.R;
import net.kaunghtetlin.sfc.adapters.NewsAdapter;
import net.kaunghtetlin.sfc.adapters.NewsImagePagerAdapter;
import net.kaunghtetlin.sfc.adapters.RelatedNewsAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Kaung Htet Lin on 11/11/2017.
 */

public class NewsDetailsActivity extends BaseActivity {

    @BindView(R.id.vp_new_details_images)
    ViewPager vpNewsDetailsImages;

    public static Intent newIntent(Context context) {
        Intent intent = new Intent(context, NewsDetailsActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_details);
        ButterKnife.bind(this, this);

        NewsImagePagerAdapter newsImagePagerAdapter = new NewsImagePagerAdapter(getApplicationContext());
        vpNewsDetailsImages.setAdapter(newsImagePagerAdapter);

        RecyclerView rvRelatedNews = findViewById(R.id.rv_realted_news);
        rvRelatedNews.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));

        RelatedNewsAdapter relatedNewsAdapter = new RelatedNewsAdapter(getApplicationContext());
        rvRelatedNews.setAdapter(relatedNewsAdapter);

    }
}
