package com.binus.idea.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;

import com.binus.idea.Product;
import com.binus.idea.ProductAdapter;
import com.binus.idea.R;
import com.binus.idea.databinding.FragmentHomeBinding;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private FragmentHomeBinding binding;

    private ArrayList<Product> products = new ArrayList<>();

    int[] images = { R.drawable.hemlingby, R.drawable.strandmon, R.drawable.malm };

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.greetingMessage;
        homeViewModel.getText().observe(getViewLifecycleOwner(), s -> textView.setText(s));

        return root;
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        populateData();
        initImages();
        initAdapter();
    }

    private void initAdapter(){
        binding.recommendedProducts.setAdapter(new ProductAdapter(products, getContext()));
        binding.recommendedProducts.setLayoutManager(new GridLayoutManager(getContext(), 2));
    }

    private void populateData(){
        products.add(new Product("Hemlingby", "Rp. 1.875.000", R.drawable.hemlingby));
        products.add(new Product("Strandmon", "Rp. 2.000.000", R.drawable.strandmon));
        products.add(new Product("Malm", "Rp. 3.500.000", R.drawable.malm));
        products.add(new Product("Malm", "Rp. 3.500.000", R.drawable.malm));
        products.add(new Product("Malm", "Rp. 3.500.000", R.drawable.malm));
    }

    public void initImages(){
        for (int image: images){
            ImageView view = new ImageView(getContext());
            view.setBackgroundResource(image);
            binding.carousel.addView(view);
        }
        binding.carousel.setInAnimation(getContext(), android.R.anim.slide_in_left);
        binding.carousel.setOutAnimation(getContext(), android.R.anim.slide_out_right);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}