package com.binus.idea.products;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.binus.idea.Product;
import com.binus.idea.ProductAdapter;
import com.binus.idea.ProductDetail;
import com.binus.idea.R;
import com.binus.idea.databinding.FragmentListProductBinding;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProductListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProductListFragment extends Fragment implements ProductAdapter.OnItemClickedListener {

    private static final String ARG_TAB = "tab_name";
    private String tabName;
    private FragmentListProductBinding binding;
    ArrayList<Product> products = new ArrayList<>();


    public ProductListFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param tabName Name of tab.
     * @return A new instance of fragment AboutUsDetailFragment.
     */
    public static ProductListFragment newInstance(String tabName) {
        ProductListFragment fragment = new ProductListFragment();
        Bundle args = new Bundle();
        args.putString(ARG_TAB, tabName);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            tabName = getArguments().getString(ARG_TAB);
        }
    }

    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentListProductBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        populateData();
        initAdapter();
    }

    private void initAdapter(){
        binding.productView.setAdapter(new ProductAdapter(products, getContext(), this));
        binding.productView.setLayoutManager(new GridLayoutManager(getContext(), 2));
    }

    private void populateData() {
        if (tabName.equalsIgnoreCase("living room")){
            products.add(new Product("HEMLINGBY", "Rp. 1.875.000", R.drawable.hemlingby));
            products.add(new Product("STRANDMON", "Rp. 2.000.000", R.drawable.strandmon));
            products.add(new Product("HEMNES", "Rp. 4.499.000", R.drawable.hemnes));
            products.add(new Product("LINANÄS", "Rp 3.495.000", R.drawable.linns));
            products.add(new Product("LACK", "Rp 899.000", R.drawable.lack));
            products.add(new Product("SVENARUM", "Rp 2.799.000", R.drawable.svenarum));
        } else if (tabName.equalsIgnoreCase("kitchen")){
            products.add(new Product("HEMLINGBY", "Rp. 1.875.000", R.drawable.hemlingby));
            products.add(new Product("STRANDMON", "Rp. 2.000.000", R.drawable.strandmon));
            products.add(new Product("HEMNES", "Rp. 4.499.000", R.drawable.hemnes));
            products.add(new Product("LINANÄS", "Rp 3.495.000", R.drawable.linns));
            products.add(new Product("LACK", "Rp 899.000", R.drawable.lack));
            products.add(new Product("SVENARUM", "Rp 2.799.000", R.drawable.svenarum));
        } else {
            products.add(new Product("HEMLINGBY", "Rp. 1.875.000", R.drawable.hemlingby));
            products.add(new Product("STRANDMON", "Rp. 2.000.000", R.drawable.strandmon));
            products.add(new Product("HEMNES", "Rp. 4.499.000", R.drawable.hemnes));
            products.add(new Product("LINANÄS", "Rp 3.495.000", R.drawable.linns));
            products.add(new Product("LACK", "Rp 899.000", R.drawable.lack));
            products.add(new Product("SVENARUM", "Rp 2.799.000", R.drawable.svenarum));
        }

    }

    @Override
    public void onClick(Product item) {
        Intent intent = new Intent(getActivity(), ProductDetail.class);
        intent.putExtra("product", item);
        startActivity(intent);
    }
}