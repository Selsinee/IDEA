package com.binus.idea.utilities;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.binus.idea.databinding.ProductItemBinding;
import com.binus.idea.entity.Product;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {

    private final OnItemClickedListener callback;
    private final ArrayList<Product> dataSet;
    private final Context mContext;

    public ProductAdapter(ArrayList<Product> data, Context context, OnItemClickedListener callback) {
        dataSet = data;
        mContext = context;
        this.callback = callback;
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
        holder.binding.itemCard.setOnClickListener(v -> callback.onClick(item));
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

    public interface OnItemClickedListener {
        void onClick(Product item);
    }
}
