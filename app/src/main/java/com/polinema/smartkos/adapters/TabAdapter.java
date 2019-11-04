package com.polinema.smartkos.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.polinema.smartkos.fragments.PengeluaranBulanIni;
import com.polinema.smartkos.fragments.PengeluaranSemuaBulan;

public class TabAdapter extends FragmentPagerAdapter {
    private int numOftabs;

    public TabAdapter(@NonNull FragmentManager fm, int numOfTabs) {
        super(fm);
        this.numOftabs = numOfTabs;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new PengeluaranBulanIni();
            case 1:
                return new PengeluaranSemuaBulan();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return numOftabs;
    }
}
