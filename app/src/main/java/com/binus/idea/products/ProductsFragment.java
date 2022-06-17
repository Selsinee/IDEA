package com.binus.idea.products;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;

import com.binus.idea.Product;
import com.binus.idea.ProductAdapter;
import com.binus.idea.R;
import com.binus.idea.aboutus.TabPagerAdapter;
import com.binus.idea.databinding.FragmentProductsBinding;
import com.google.android.material.tabs.TabLayoutMediator;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;


public class ProductsFragment extends Fragment {

    ArrayList<Product> products;
    private FragmentProductsBinding binding;
    private final String TAB_LIVING_ROOM = "Living room";
    private final String TAB_KITCHEN = "Kitchen";
    private final String TAB_BATHROOM = "Bathroom";

    private static final String ARG_Tab = "tab_name";
    private String tab_Name;


    @NonNull
    public static ProductsFragment newInstance(String tab_Name) {
        ProductsFragment fragment = new ProductsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_Tab, tab_Name);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            tab_Name = getArguments().getString(ARG_Tab);
        }
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentProductsBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.productView.setAdapter(new TabPagerAdapter2(this));
        new TabLayoutMediator(binding.tabLayout2, binding.productView, ((tab, position) -> {
            if (position == 0){
                tab.setText(TAB_LIVING_ROOM);
            } else if (position == 1) {
                tab.setText(TAB_KITCHEN);
            } else if (position == 2){
                tab.setText(TAB_BATHROOM);
            }
        })).attach();
        populateData();
        initAdapter();
    }

    private void initAdapter(){
        binding.productView.setAdapter(new ProductAdapter(products, getContext()));
        binding.productView.setLayoutManager(new GridLayoutManager(getContext(), 2));
    }

    private void populateData() {
        products.add(new Product("HEMLINGBY", "Rp. 1.875.000", R.drawable.hemlingby));
        products.add(new Product("STRANDMON", "Rp. 2.000.000", R.drawable.strandmon));
        products.add(new Product("HEMNES", "Rp. 4.499.000", R.drawable.hemnes));
        products.add(new Product("LINANÄS", "Rp 3.495.000", R.drawable.linns));
        products.add(new Product("LACK", "Rp 899.000", R.drawable.lack));
        products.add(new Product("SVENARUM", "Rp 2.799.000", R.drawable.svenarum));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}