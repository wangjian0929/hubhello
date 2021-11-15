package com.feedAustralia.android.AdpatersPagers;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import com.feedAustralia.android.Fragment.Analytics;
import com.feedAustralia.android.Fragment.EatingHabits;
import com.feedAustralia.android.Fragment.MenuFragment;
import com.feedAustralia.android.Fragment.MenuIdeas;
import java.util.ArrayList;

/**
 * Created by asd on 04-02-2019.
 */

public class HomeViewPagerAdapter extends FragmentPagerAdapter {
    private ArrayList<Fragment> fragments = new ArrayList<>();
    private Object currentFragment;
    public HomeViewPagerAdapter(FragmentManager fm) {
        super(fm);
        fragments.clear();
        fragments.add(new MenuFragment());
        fragments.add(MenuIdeas.newInstance());
        fragments.add(EatingHabits.newInstance());
        fragments.add(Analytics.newInstance());
    }
    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }
    @Override
    public int getCount() {
        return fragments.size();
    }
    @Override
    public void setPrimaryItem(ViewGroup container, int position, Object object) {
        if (getCurrentFragment() != object) {
            currentFragment = (object);
        }
        super.setPrimaryItem(container, position, object);
    }
    public Object getCurrentFragment() {
        return currentFragment;
    }
}