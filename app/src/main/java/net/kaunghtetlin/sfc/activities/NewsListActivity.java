package net.kaunghtetlin.sfc.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import net.kaunghtetlin.sfc.R;
import net.kaunghtetlin.sfc.adapters.NewsAdapter;
import net.kaunghtetlin.sfc.delegates.NewsItemDelegate;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NewsListActivity extends AppCompatActivity implements NewsItemDelegate{

    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ButterKnife.bind(this,this);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              /*  Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();*/

              drawerLayout.openDrawer(GravityCompat.START);
            }
        });

        RecyclerView rvNew = findViewById(R.id.rv_news);
        rvNew.setLayoutManager(new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false));

        NewsAdapter newsAdapter=new NewsAdapter(getApplicationContext(),this);
        rvNew.setAdapter(newsAdapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onTapComment() {

    }

    @Override
    public void onTapSendTo() {

    }

    @Override
    public void onTapFavorite() {

    }

    @Override
    public void onTapStatistics() {

    }

    @Override
    public void onTapNews() {
        Intent intent=NewsDetailsActivity.newIntent(getApplicationContext());
//        startActivity(intent);

        ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(
                // the context of the activity
                this,

                // For each shared element, add to this method a new Pair item,
                // which contains the reference of the view we are transitioning *from*,
                // and the value of the transitionName attribute
                new Pair<View, String>(findViewById(R.id.iv_publication_logo),
                        getString(R.string.transition_name_publication_image)),
                new Pair<View, String>(findViewById(R.id.tv_publication_name),
                        getString(R.string.transition_name_publication_name)),
                new Pair<View, String>(findViewById(R.id.tv_published_date),
                        getString(R.string.transition_name_posted_date)),
                new Pair<View, String>(findViewById(R.id.iv_news_hero_image),
                        getString(R.string.transition_name_hero_image))
        );
        ActivityCompat.startActivity(this, intent, options.toBundle());
    }
}
