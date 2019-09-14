package com.example.jumction.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jumction.R;

import androidx.fragment.app.Fragment;

public class ItemTreeFragment extends Fragment {
    public static ItemTreeFragment newInstance() {
        ItemTreeFragment fragment = new ItemTreeFragment();
        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_item_three, container, false);
    }
}
