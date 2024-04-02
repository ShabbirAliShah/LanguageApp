package com.example.languageapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.languageapp.Models.Languages;
import com.example.languageapp.R;

import java.util.ArrayList;

public class AvailableCoureseAdapter extends RecyclerView.Adapter<AvailableCoureseAdapter.ViewHolder> {

    private final ArrayList<Languages> languageList;
    private final Context context;

    public AvailableCoureseAdapter(ArrayList<Languages> languageList, Context context) {
        this.languageList = languageList;
        this.context = context;
    }

    @NonNull
    @Override
    public AvailableCoureseAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.languageList_card, parent, false);
        return new AvailableCoureseAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AvailableCoureseAdapter.ViewHolder holder, int position) {
        Languages langModel = languageList.get(position);
        holder.languageText.setText(langModel.getLanguage());

    }

    @Override
    public int getItemCount() {
        return languageList.size();
    }

    public  static class ViewHolder extends RecyclerView.ViewHolder{

        TextView languageText;
        public ViewHolder(@NonNull View ItemView) {
            super(ItemView);

            languageText = itemView.findViewById(R.id.languageTextView);
        }
    }
}
