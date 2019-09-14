package com.example.jumction.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jumction.R;
import com.example.jumction.mdel.report;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ReportAdapter extends RecyclerView.Adapter<ReportAdapter.ViewHolder>{
    private ArrayList<report> listdata;
    Context context;
    // RecyclerView recyclerView;
    public ReportAdapter(ArrayList<report>  listdata,Context context) {
        this.listdata = listdata;
        this.context = context;
    }







    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

        View listItem= layoutInflater.inflate(R.layout.report_cardview, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.DateTextView.setText(listdata.get(position).getDate());
        holder.ActualTextView.setText(String.valueOf(listdata.get(position).getActual()));
        holder.BudgetTextView.setText(String.valueOf(listdata.get(position).getBudget()));

        if(listdata.get(position).getActual()<listdata.get(position).getBudget()){
            holder.ActualTextView.setTextColor(Color.YELLOW);
        }
        else if(listdata.get(position).getActual()==listdata.get(position).getBudget()){
            holder.ActualTextView.setTextColor(Color.GREEN);
        }
        else if(listdata.get(position).getActual() == 0){
            holder.ActualTextView.setText("-");
        }
        else{
            holder.ActualTextView.setTextColor(Color.RED);
        }

    }

    @Override
    public int getItemCount() {
        return listdata.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {


        public TextView DateTextView;
        public TextView ActualTextView;
        public TextView BudgetTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            DateTextView = (TextView) itemView.findViewById(R.id.time);
            BudgetTextView = (TextView) itemView.findViewById(R.id.real);
            ActualTextView = (TextView) itemView.findViewById(R.id.Budget);
        }
    }
}