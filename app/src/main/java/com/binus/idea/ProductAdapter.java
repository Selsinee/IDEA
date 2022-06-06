package com.binus.idea;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.binus.idea.databinding.ProductItemBinding;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {

    private ArrayList<Product> dataSet;
    private Context mContext;

    public ProductAdapter(ArrayList<Product> data, Context context){
        dataSet = data;
        mContext = context;
    }

    @NonNull
    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        ProductItemBinding binding = ProductItemBinding.inflate(LayoutInflater.from(mContext), parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ViewHolder holder, int position) {
        Product item = dataSet.get(position);
        holder.binding.productImage.setImageResource(item.getImage());
        holder.binding.productName.setText(item.getName());
        holder.binding.productPrice.setText(item.getPrice());
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ProductItemBinding binding;

        public ViewHolder(ProductItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

    }
}
