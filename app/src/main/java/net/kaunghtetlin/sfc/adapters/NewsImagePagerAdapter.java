package net.kaunghtetlin.sfc.adapters;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.kaunghtetlin.sfc.R;

/**
 * Created by Kaung Htet Lin on 11/11/2017.
 */

public class NewsImagePagerAdapter extends PagerAdapter {

    private LayoutInflater mLayoutInflator;

    public NewsImagePagerAdapter(Context context) {
        super();
        mLayoutInflator = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return 5;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view == (View) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View itemView = mLayoutInflator.inflate(R.layout.view_item_news_details_image, container, false);
        container.addView(itemView);

        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View)object);
//        super.destroyItem(container, position, object);
    }

}
