package com.polinema.smartkos.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class TabAdapter extends FragmentPagerAdapter {
    private List<Fragment> lstFragment = new ArrayList<>();
    private List<String> lstTitles = new ArrayList<>();

    public TabAdapter(FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return lstFragment.get(position);
    }

    @Override
    public int getCount() {
        return 2;
    }

    public CharSequence getPageTitle(int position) {
       return lstTitles.get(position);
    }

    public void AddFragment (Fragment fragment,String title) {
        lstFragment.add(fragment);
        lstTitles.add(title);
    }
}
