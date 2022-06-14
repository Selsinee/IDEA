package com.binus.idea.aboutus;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.binus.idea.databinding.FragmentAboutUsDetailBinding;

import org.jetbrains.annotations.NotNull;

public class TabPagerAdapter extends FragmentStateAdapter {

    public TabPagerAdapter(@NonNull @NotNull Fragment fragment) {
        super(fragment);
    }

    @NonNull
    @NotNull
    @Override
    public Fragment createFragment(int position) {
        String TAB_SOCIAL_MEDIA = "Social Media";
        String TAB_ABOUT = "About";

        Fragment fragment;

        switch(position){
            case 0: {
                fragment = AboutUsDetailFragment.newInstance(TAB_ABOUT);
                break;
            }
            case 1: {
                fragment = AboutUsDetailFragment.newInstance(TAB_SOCIAL_MEDIA);
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
        return 2;
    }
}
