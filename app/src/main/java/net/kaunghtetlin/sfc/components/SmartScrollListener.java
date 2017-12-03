package net.kaunghtetlin.sfc.components;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

/**
 * Created by Kaung Htet Lin on 11/26/2017.
 */

public class SmartScrollListener extends RecyclerView.OnScrollListener {

    public interface OnSmartScrollListener {
        void onListEndReach();
    }

    private int visibleItemCount, pastVisibleItems, totalItemCount;
    private boolean isListEndReached = false;
    private int previousDy, currentDy;

    private OnSmartScrollListener mSmartScrollListener;

    public SmartScrollListener(OnSmartScrollListener mSmartScrollListener) {
        this.mSmartScrollListener = mSmartScrollListener;
    }

    @Override
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView, dx, dy);

        currentDy = dy;
        if (currentDy > previousDy) {
            //from top to bottom
        } else if (currentDy < previousDy) {
            //form bottom to top
            isListEndReached = false;
        }

        visibleItemCount = recyclerView.getLayoutManager().getChildCount();
        totalItemCount = recyclerView.getLayoutManager().getItemCount();
        pastVisibleItems = ((LinearLayoutManager) recyclerView.getLayoutManager()).findFirstVisibleItemPosition();

        previousDy = currentDy;
    }

    @Override
    public void onScrollStateChanged(RecyclerView recyclerView, int scrollState) {
        super.onScrollStateChanged(recyclerView, scrollState);
        if (scrollState == RecyclerView.SCROLL_STATE_IDLE) {
            if ((visibleItemCount + pastVisibleItems) >= totalItemCount && !isListEndReached) {
                isListEndReached = true;
                mSmartScrollListener.onListEndReach();
            }
        }
    }
}
