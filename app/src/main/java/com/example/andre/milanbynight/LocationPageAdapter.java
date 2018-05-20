package com.example.andre.milanbynight;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class LocationPageAdapter extends FragmentPagerAdapter
{

    private Context context;

    public LocationPageAdapter(FragmentManager fm, Context context)
    {
        super(fm);
        this.context = context;
    }

    @Override
    public int getCount()
    {
        return 4;
    }

    @Override
    public Fragment getItem(int position)
    {
        if (position == 0)
        {
            return new DiscoFragment();
        }
        else if (position == 1)
        {
            return new ResturantFragment();
        }
        else if (position == 2)
        {
            return new PubFragment();
        }
        else
        {
            return new SushiFragment();
        }
    }

    @Override
    public CharSequence getPageTitle(int position)
    {
        if (position == 0)
        {
            return context.getString(R.string.disco);
        }
        else if (position == 1)
        {
            return context.getString(R.string.food);
        }
        else if (position == 2)
        {
            return context.getString(R.string.pub);
        }
        else
        {
            return context.getString(R.string.sushi);
        }
    }
}
