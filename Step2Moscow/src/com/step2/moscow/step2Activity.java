
package com.step2.moscow;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.ActionBar.Tab;
import com.actionbarsherlock.app.ActionBar.TabListener;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.Menu;
import com.step2.moscow.adapter.ViewPagerAdapter;

public class step2Activity
    extends SherlockFragmentActivity
    implements OnPageChangeListener, TabListener
{

    private String[] locations;
    private ViewPager pager;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        locations = getResources().getStringArray(R.array.locations);
        pager = ((ViewPager) findViewById(R.id.pager));
        configureViewPager();
        configureActionBar();
    }

    private void configureViewPager() {
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), locations);
        pager.setAdapter(viewPagerAdapter);
        pager.setOnPageChangeListener(this);
    }

    public void onPageSelected(int position) {
        Tab tab = getSupportActionBar().getTabAt(position);
        getSupportActionBar().selectTab(tab);
    }

    private void configureActionBar() {
        getSupportActionBar().setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        ActionBar actionBar = getSupportActionBar();
        /*for (String location: locations) {
            Tab tab = getSupportActionBar().newTab();
            tab.setCustomView(R.layout.menu_item1);
            tab.setText(location);
            tab.setTabListener(this);
            getSupportActionBar().addTab(tab);
        }*/

        Tab tab = getSupportActionBar().newTab();
        tab.setCustomView(R.layout.menu_item1);
        tab.setTabListener(this);
        getSupportActionBar().addTab(tab);

        Tab tab1 = getSupportActionBar().newTab();
        tab1.setCustomView(R.layout.menu_item2);
        tab1.setTabListener(this);
        getSupportActionBar().addTab(tab1);

        Tab tab2 = getSupportActionBar().newTab();
        tab2.setCustomView(R.layout.menu_item3);
        tab2.setTabListener(this);
        getSupportActionBar().addTab(tab2);
    }

    @Override
    public void onTabSelected(Tab tab, FragmentTransaction ft) {
        int position = tab.getPosition();
        pager.setCurrentItem(position);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getSupportMenuInflater();
        return true;
    }
    @Override
    public void onPageScrollStateChanged(int position) {}

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {}

    @Override
    public void onTabUnselected(Tab tab, FragmentTransaction ft) {}

    @Override
    public void onTabReselected(Tab tab, FragmentTransaction ft) {}
}
