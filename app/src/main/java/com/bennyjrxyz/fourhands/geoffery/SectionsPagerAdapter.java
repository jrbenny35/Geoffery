package com.bennyjrxyz.fourhands.geoffery;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.widget.Switch;

/**
 * Created by bennyjr on 4/4/16.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

    public SectionsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).

        switch(position){
            case 0:
                return MainViewFragment.newInstance("0", "Page 1");
            default:
                return null;
        }

    }

    @Override
    public int getCount() {
        // Show 3 total pages.
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Section 1";
            case 1:
                return "SECTION 2";
            case 2:
                return "SECTION 3";
            case 3:
                return "SECTION 4";
        }
        return null;
    }
}
