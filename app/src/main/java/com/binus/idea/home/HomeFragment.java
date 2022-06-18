package com.binus.idea.home;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
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
import com.binus.idea.ProductDetail;
import com.binus.idea.R;
import com.binus.idea.databinding.FragmentHomeBinding;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class HomeFragment extends Fragment implements ProductAdapter.OnItemClickedListener {

    private HomeViewModel homeViewModel;
    private FragmentHomeBinding binding;

    private final ArrayList<Product> products = new ArrayList<>();

    int[] images = {R.drawable.hemlingby, R.drawable.strandmon, R.drawable.malm};

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        SharedPreferences sp = requireContext().getSharedPreferences("IDEAData", Context.MODE_PRIVATE);
        homeViewModel.setText(sp.getString("username", ""));

        final TextView textView = binding.greetingMessage;
        homeViewModel.getText().observe(getViewLifecycleOwner(), s -> textView.setText(getString(R.string.welcome_message, s)));

        return root;
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        populateData();
        initImages();
        initAdapter();
    }

    private void initAdapter() {
        binding.recommendedProducts.setAdapter(new ProductAdapter(products, getContext(), this));
        binding.recommendedProducts.setLayoutManager(new GridLayoutManager(getContext(), 2));
    }

    private void populateData() {
        products.add(new Product("Hemlingby", "Rp. 1.875.000", R.drawable.hemlingby));
        products.add(new Product("Strandmon", "Rp. 2.000.000", R.drawable.strandmon));
        products.add(new Product("HORNAVAN", "Rp 199.000", R.drawable.hornavan));
        products.add(new Product("RÅSKOG", "Rp 699.000", R.drawable.raskog));
        products.add(new Product("TVÄLLEN / ENHET", "Rp 3.999.000", R.drawable.tvallen));
        products.add(new Product("LACK", "Rp 899.000", R.drawable.lack));
        products.add(new Product("KNOXHULT", "Rp 2.750.000", R.drawable.knoxhult));
        products.add(new Product("SVENARUM", "Rp 2.799.000", R.drawable.svenarum));
    }

    public void initImages() {
        for (int image : images) {
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

    @Override
    public void onClick(Product item) {
        Intent intent = new Intent(getActivity(), ProductDetail.class);
        intent.putExtra("product", item);
        startActivity(intent);
    }
}