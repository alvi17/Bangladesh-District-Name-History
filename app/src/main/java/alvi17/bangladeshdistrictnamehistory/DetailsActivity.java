package alvi17.bangladeshdistrictnamehistory;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

import java.util.ArrayList;
import java.util.List;

import alvi17.bangladeshdistrictnamehistory.fragments.Barisal;
import alvi17.bangladeshdistrictnamehistory.fragments.Chittagong;
import alvi17.bangladeshdistrictnamehistory.fragments.Dhaka;
import alvi17.bangladeshdistrictnamehistory.fragments.Khulna;
import alvi17.bangladeshdistrictnamehistory.fragments.Maymensing;
import alvi17.bangladeshdistrictnamehistory.fragments.Rajshahi;
import alvi17.bangladeshdistrictnamehistory.fragments.Rangpur;
import alvi17.bangladeshdistrictnamehistory.fragments.Shylet;

/**
 * Created by Alvi17 on 7/25/2015.
 */
public class DetailsActivity extends AppCompatActivity{
    FrameLayout frame;
    private ListView mDrawerList;
    private DrawerLayout mDrawerLayout;
    AdView adView;
    private InterstitialAd interstitial;
    private ActionBarDrawerToggle mDrawerToggle;
    private String mActivityTitle;
    List<DrawerItem> dataList;
    Custom_Drawer_Adapter adapter;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_layout);
        frame=(FrameLayout)findViewById(R.id.detailsFrame);
        if(savedInstanceState == null)
        {
            getFragmentManager().beginTransaction().add(R.id.detailsFrame,new Dhaka()).commit();
        }
        Toast.makeText(getApplicationContext(),getResources().getString(R.string.others), Toast.LENGTH_LONG).show();
        mDrawerList = (ListView)findViewById(R.id.function_navList);
        mDrawerLayout = (DrawerLayout)findViewById(R.id.function_drawer_layout);
        mActivityTitle = getTitle().toString();
        dataList = new ArrayList<DrawerItem>();
        // addDrawerItems();
        dataList.add(new DrawerItem(getResources().getString(R.string.dhaka), R.mipmap.ic_launcher));

        dataList.add(new DrawerItem(getResources().getString(R.string.ctg), R.mipmap.ic_launcher));
        dataList.add(new DrawerItem(getResources().getString(R.string.shylet), R.mipmap.ic_launcher));
        dataList.add(new DrawerItem(getResources().getString(R.string.khulna), R.mipmap.ic_launcher));
        dataList.add(new DrawerItem(getResources().getString(R.string.barisal), R.mipmap.ic_launcher));
        dataList.add(new DrawerItem(getResources().getString(R.string.rajshahi), R.mipmap.ic_launcher));
        dataList.add(new DrawerItem(getResources().getString(R.string.rangpur), R.mipmap.ic_launcher));
        dataList.add(new DrawerItem(getResources().getString(R.string.maymyesing), R.mipmap.ic_launcher));
        // adding a header to the list


        adapter = new Custom_Drawer_Adapter(this, R.layout.custom_drawer_item,
                dataList);

        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.drawer_open, R.string.drawer_close) {

            /** Called when a drawer has settled in a completely open state. */
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                getSupportActionBar().setTitle(getResources().getString(R.string.select));
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }

            /** Called when a drawer has settled in a completely closed state. */
            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }
        };

        mDrawerToggle.setDrawerIndicatorEnabled(true);
        mDrawerLayout.setDrawerListener(mDrawerToggle);
        //     setupDrawer();
        adapter = new Custom_Drawer_Adapter(this, R.layout.custom_drawer_item,
                dataList);

        mDrawerList.setAdapter(adapter);

        mDrawerList.setOnItemClickListener(new DrawerItemClickListener());
        getSupportActionBar().setTitle(getResources().getString(R.string.dhaka));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        interstitial=new  InterstitialAd(this);
        interstitial.setAdUnitId("ca-app-pub-6508526601344465/9023156831");
        AdRequest aRequest = new AdRequest.Builder().build();

        // Begin loading your interstitial.
        interstitial.loadAd(aRequest);

        interstitial.setAdListener(
                new AdListener() {
                   @Override
                    public void onAdLoaded() {
                        super.onAdLoaded();
                        interstitial.show();
                    }
                }
        );

        adView = new AdView(this);
        adView.setAdUnitId("ca-app-pub-6508526601344465/7546423633");
        adView.setAdSize(AdSize.BANNER);
        LinearLayout layout = (LinearLayout)findViewById(R.id.linearLayout);
        layout.setGravity(Gravity.BOTTOM|Gravity.CENTER_HORIZONTAL);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);
        layout.addView(adView);


    }
    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        mDrawerToggle.syncState();
    }
    public void SelectItem(int position) {

        switch(position) {
            case 0:

                getFragmentManager().beginTransaction().replace(R.id.detailsFrame, new Dhaka()).commit();
                getSupportActionBar().setTitle(getResources().getString(R.string.dhaka));
                break;
            case 1:
               // getFragmentManager().beginTransaction().replace(R.id.function_frame, new ArithGeom()).commit();
                getFragmentManager().beginTransaction().replace(R.id.detailsFrame, new Chittagong()).commit();
                getSupportActionBar().setTitle(getResources().getString(R.string.ctg));
                break;
            case 2:
                getFragmentManager().beginTransaction().replace(R.id.detailsFrame, new Shylet()).commit();
                getSupportActionBar().setTitle(getResources().getString(R.string.shylet));
                break;
            case 3:
                getFragmentManager().beginTransaction().replace(R.id.detailsFrame, new Khulna()).commit();
                getSupportActionBar().setTitle(getResources().getString(R.string.khulna));
                break;
            case 4:
                getFragmentManager().beginTransaction().replace(R.id.detailsFrame, new Barisal()).commit();
                getSupportActionBar().setTitle(getResources().getString(R.string.barisal));
                break;
            case 5:
                getFragmentManager().beginTransaction().replace(R.id.detailsFrame, new Rajshahi()).commit();
                getSupportActionBar().setTitle(getResources().getString(R.string.rajshahi));
                break;
            case 6:
                getFragmentManager().beginTransaction().replace(R.id.detailsFrame, new Rangpur()).commit();
                getSupportActionBar().setTitle(getResources().getString(R.string.rangpur));
                break;
            case 7:
                getFragmentManager().beginTransaction().replace(R.id.detailsFrame, new Maymensing()).commit();
                getSupportActionBar().setTitle(getResources().getString(R.string.maymyesing));
                break;

        }
        mDrawerList.setItemChecked(position, true);
        setTitle(dataList.get(position).getItemName());
        mDrawerLayout.closeDrawer(mDrawerList);

    }
    private class DrawerItemClickListener implements
            ListView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position,
                                long id) {

            //	Toast.makeText(getApplicationContext(), "Clicked",Toast.LENGTH_LONG).show();
            if (dataList.get(position).getTitle() == null) {
                SelectItem(position);
            }
        }
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
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



        // Activate the navigation drawer toggle
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onBackPressed() {

        AlertDialog.Builder alert=new AlertDialog.Builder(this);
        alert.setTitle("Exit");
        alert.setMessage("Do you want to Exit?");
        alert.setPositiveButton("Exit", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();

            }
        });
        alert.setNegativeButton("Cancel", null);
        AlertDialog dialog=alert.create();
        dialog.show();
    }
}
