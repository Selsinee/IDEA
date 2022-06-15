package com.binus.idea;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ImageView;

public class ProductDetail extends AppCompatActivity {
    TextView price;
    ImageView photos;
    TextView title;
    Button buy;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_detail);
//        title = findViewById();
//        photos = findViewById();
//        price = findViewById();
        //(.....).setOnClickListener(v -> {
        //  Product product = com.binus.idea.Product.getInstance();
        //  product.setData(product_name);
        //  product.setData(product_image);
        //  product.setData(product_price);
        //  (.....).setText(product.getData());
        //}

    }
}
