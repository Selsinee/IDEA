package com.binus.idea.aboutus;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.binus.idea.databinding.FragmentAboutUsBinding;
import com.google.android.material.tabs.TabLayoutMediator;

import org.jetbrains.annotations.NotNull;


public class AboutUsFragment extends Fragment {

    private FragmentAboutUsBinding binding;
    private final String TAB_ABOUT = "About";
    private final String TAB_SOCIAL_MEDIA = "Social Media";

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentAboutUsBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.viewPager.setAdapter(new TabPagerAdapter(this));
        new TabLayoutMediator(binding.tabLayout, binding.viewPager, ((tab, position) -> {
            if (position == 0){
                tab.setText(TAB_ABOUT);
            } else if (position == 1) {
                tab.setText(TAB_SOCIAL_MEDIA);
            }
        })).attach();

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }


}