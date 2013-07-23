
package com.step2.moscow.adapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.step2.moscow.SampleFragment;

public class ViewPagerAdapter
    extends FragmentPagerAdapter
{

    private String[] locations;

    public ViewPagerAdapter(FragmentManager fm, String[] locations) {
        super(fm);
        this.locations = locations;
    }

    public int getCount() {
        return locations.length;
    }

    public Fragment getItem(int position) {
        Fragment fragment = new SampleFragment();
        Bundle bundle = new Bundle();
        bundle.putString("label", locations[position]);
        fragment.setArguments(bundle);
        return fragment;
    }

}
