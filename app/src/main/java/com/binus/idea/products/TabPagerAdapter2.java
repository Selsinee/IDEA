package com.binus.idea.products;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import org.jetbrains.annotations.NotNull;

public class TabPagerAdapter2 extends FragmentStateAdapter {

    public TabPagerAdapter2(@NonNull @NotNull Fragment fragment) {
        super(fragment);
    }

    @NonNull
    @NotNull
    @Override
    public Fragment createFragment(int position) {
        String TAB_LIVING_ROOM = "Living room";
        String TAB_KITCHEN = "Kitchen";
        String TAB_BATHROOM = "Bathroom";

        Fragment fragment;

        switch(position){
            case 0: {
                fragment = ProductsFragment.newInstance(TAB_LIVING_ROOM);
                break;
            }
            case 1: {
                fragment = ProductsFragment.newInstance(TAB_KITCHEN);
                break;
            }
            case 2:{
                fragment = ProductsFragment.newInstance(TAB_BATHROOM);
                break;
            }
            default: {
                fragment = new Fragment();
                break;
            }
        }
        return fragment;
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}

