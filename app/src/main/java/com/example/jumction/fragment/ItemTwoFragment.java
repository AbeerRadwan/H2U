package com.example.jumction.fragment;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.budiyev.android.circularprogressbar.CircularProgressBar;
import com.example.jumction.R;

import androidx.fragment.app.Fragment;

public class ItemTwoFragment extends Fragment {
    ProgressBar progressBar;
    public static ItemTwoFragment newInstance() {
        ItemTwoFragment fragment = new ItemTwoFragment();
        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_item_two, container, false);
        CircularProgressBar progressBar = view.findViewById(R.id.progress_bar);
        progressBar.setProgress(100f);

        return view;
    }
}
