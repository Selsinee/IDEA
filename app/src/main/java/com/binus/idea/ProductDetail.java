package com.binus.idea;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ImageView;
import com.binus.idea.databinding.ProductDetailBinding;

public class ProductDetail extends AppCompatActivity {

    private ProductDetailBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);


        binding = ProductDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.buybutton.setOnClickListener(v -> {
            String inp = binding.quant.getText().toString();
            int quantity = Integer.parseInt(inp);

            if(quantity > 0){
                successDialog();
            }
            else{
                failDialog();
            }
        });






    }

    void failDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("empty")
                .setPositiveButton("ok", (dialog, id) -> {
                });
        // Create the AlertDialog object and return it
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    void successDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Success")
                .setPositiveButton("ok", (dialog, id) -> {
                });
        // Create the AlertDialog object and return it
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

}
