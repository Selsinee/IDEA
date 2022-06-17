package com.binus.idea.products;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.binus.idea.databinding.FragmentProductsBinding;
import com.google.android.material.tabs.TabLayoutMediator;

import org.jetbrains.annotations.NotNull;


public class ProductsFragment extends Fragment {

    private FragmentProductsBinding binding;
    private final String TAB_LIVING_ROOM = "Living room";
    private final String TAB_KITCHEN = "Kitchen";
    private final String TAB_BATHROOM = "Bathroom";


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentProductsBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.viewPager.setAdapter(new TabPagerAdapter2(this));
        new TabLayoutMediator(binding.tabLayout2, binding.viewPager, ((tab, position) -> {
            if (position == 0) {
                tab.setText(TAB_LIVING_ROOM);
            } else if (position == 1) {
                tab.setText(TAB_KITCHEN);
            } else if (position == 2) {
                tab.setText(TAB_BATHROOM);
            }
        })).attach();

    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}