package com.binus.idea.aboutus;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.binus.idea.databinding.FragmentAboutUsDetailBinding;

import org.jetbrains.annotations.NotNull;

public class AboutUsDetailFragment extends Fragment {

    private static final String ARG_TAB = "tab_name";
    private String tabName;
    private FragmentAboutUsDetailBinding binding;

    public AboutUsDetailFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param tabName Name of tab.
     * @return A new instance of fragment AboutUsDetailFragment.
     */
    public static AboutUsDetailFragment newInstance(String tabName) {
        AboutUsDetailFragment fragment = new AboutUsDetailFragment();
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
        binding = FragmentAboutUsDetailBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (tabName.toLowerCase().equals("about")){
            binding.contentText.setVisibility(View.VISIBLE);
            binding.socialMediaTab.setVisibility(View.GONE);
        } else {
            binding.contentText.setVisibility(View.GONE);
            binding.socialMediaTab.setVisibility(View.VISIBLE);
        }

        binding.facebook.setOnClickListener(v -> {
            Uri uri = Uri.parse("http://www.facebook.com");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        });

        binding.instagram.setOnClickListener(v -> {
            Uri uri = Uri.parse("http://www.instagram.com");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        });

        binding.website.setOnClickListener(v -> {
            Uri uri = Uri.parse("http://www.google.com");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        });

    }
}