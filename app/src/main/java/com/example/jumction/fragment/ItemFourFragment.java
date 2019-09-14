package com.example.jumction.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.budiyev.android.circularprogressbar.CircularProgressBar;
import com.example.jumction.R;
import com.example.jumction.adapter.ReportAdapter;
import com.example.jumction.mdel.report;

import java.util.ArrayList;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ItemFourFragment extends Fragment {
    ProgressBar progressBar;
    ArrayList<report> reports;
    public static ItemFourFragment newInstance() {
        ItemFourFragment fragment = new ItemFourFragment();
        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_item_four, container, false);

        reports = new ArrayList<report>();
        reports.add(new report("13 Sep 2019 Friday",50,40));
        reports.add(new report("14 Sep 2019 Saturday",50,50));
        reports.add(new report("15 Sep 2019 Wednesday",50,0));
        reports.add(new report("15 Sep 2019 Wednesday",50,60));

        RecyclerView recyclerView = view.findViewById(R.id.reportRecycleView);
        ReportAdapter reportAdapter = new ReportAdapter(reports,getContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(reportAdapter);


        return view;
    }
}
