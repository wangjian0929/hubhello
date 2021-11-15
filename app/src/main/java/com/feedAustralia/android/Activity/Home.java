package com.feedAustralia.android.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.Menu;

import com.feedAustralia.android.AdpatersPagers.HomeViewPagerAdapter;
import com.feedAustralia.android.Fragment.Analytics;
import com.feedAustralia.android.Fragment.EatingHabits;
import com.feedAustralia.android.Fragment.MenuFragment;
import com.feedAustralia.android.Fragment.MenuIdeas;
import com.feedAustralia.android.Others.AMBottomNavigationView;
import com.feedAustralia.android.R;
import com.feedAustralia.android.pojo.habit.EatingHabit;

import java.util.List;


/**
 * Created by asd on 04-02-2019.
 */

public class Home extends BaseActivity implements ViewPager.OnPageChangeListener {
    private ViewPager viewPager;
    private Object currentFragment;
    private HomeViewPagerAdapter adapter;
    AMBottomNavigationView navigation;
    Boolean loadEatingHabit = false;
    Boolean loadAnalytics = false;
    Boolean loadRecipe = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_screen);
        String auth_token= getIntent().getStringExtra("auth_token");
        navigation =findViewById(R.id.navigation);
        navigation.addItemsCount(4);
        viewPager = findViewById(R.id.view_pager);
        viewPager.setOffscreenPageLimit(4);
        adapter = new HomeViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        currentFragment = adapter.getCurrentFragment();
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

//    @Override
//    public void onBackPressed() {
//
//        List fragmentList = getSupportFragmentManager().getFragments();
//
//        boolean handled = false;
//        for(Object f:fragmentList) {
//            if(f instanceof EatingHabits) {
//                handled = ((EatingHabits)f).onBackPressed();
//
//                if(handled) {
//                    break;
//                }
//            }
//        }
//
//        if(!handled) {
//            super.onBackPressed();
//        }
//    }
//


    private AMBottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new AMBottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(int position, boolean wasSelected) {
            if (currentFragment == null) {
                currentFragment = adapter.getCurrentFragment();
            }
            viewPager.setCurrentItem(position, false);
            currentFragment = adapter.getCurrentFragment();

            if(position ==1)
            {
                if(!loadRecipe)
                {
                    MenuIdeas ideas =  (MenuIdeas) adapter.getCurrentFragment();
                    ideas.apigroup();
                    loadRecipe  =true;
                }
            }
            else if(position ==2)
            {
                if(!loadEatingHabit)
                {
                    EatingHabits habits =  (EatingHabits) adapter.getCurrentFragment();
                    habits.getfamilymember();
                    loadEatingHabit = true;


                }
            }
            else if(position==3)
            {
                if(!loadAnalytics)
                {
                    Analytics analytics =  (Analytics) adapter.getCurrentFragment();
                    analytics.getfamilymember();
                    loadAnalytics = true;
                }
            }
            return true;
        }
    };
    @Override
    public void onBackPressed() {
        if (adapter.getCurrentFragment() instanceof MenuFragment) {

            boolean handled = false;
            handled = ((MenuFragment)adapter.getCurrentFragment()).onBackPressed();
            if(!handled) {
            }

        }
        else if(adapter.getCurrentFragment() instanceof EatingHabits)
        {
            boolean handled = false;
            handled = ((EatingHabits)adapter.getCurrentFragment()).onBackPressed();
            if(!handled) {
            }


        }
        else if(adapter.getCurrentFragment() instanceof Analytics)
        {
            boolean handled = false;
            handled = ((Analytics)adapter.getCurrentFragment()).onBackPressed();
            if(!handled) {
            }


        }

        else if(adapter.getCurrentFragment() instanceof MenuIdeas)
        {


        }
        else
        {
            viewPager.setCurrentItem(0, false);
            navigation.Update();
            currentFragment = adapter.getCurrentFragment();
            super.onBackPressed();

        }

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels)
    {

    }

    @Override
    public void onPageSelected(int position)
    {
        if(position==1)
        {
            if(!loadRecipe)
            {

            }

        }
        else if(position ==2)
        {
            if(!loadEatingHabit)
            {

            }

        }
        else if(position ==3)
        {
            if(!loadAnalytics)
            {

            }
        }

    }

    @Override
    public void onPageScrollStateChanged(int state)
    {
    }

}