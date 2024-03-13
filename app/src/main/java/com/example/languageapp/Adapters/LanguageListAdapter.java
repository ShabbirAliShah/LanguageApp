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

public class LanguageListAdapter extends RecyclerView.Adapter<LanguageListAdapter.ViewHolder> {

private final ArrayList<Languages> languageList;
private final Context context;

public LanguageListAdapter(ArrayList<Languages> languageList, Context context){
    this.languageList = languageList;
    this.context = context;

}
    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView keyText, languageText, countryText;

        public ViewHolder(@NonNull View itemView){
            super(itemView);

            keyText = itemView.findViewById(R.id.keyTextView);
            languageText = itemView.findViewById(R.id.languageTextView);
            countryText = itemView.findViewById(R.id.countryTextView);

        }
    }

    @NonNull
    @Override

public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){

    View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.language_card, parent, false);
    return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position){

    Languages langModel = languageList.get(position);
    holder.keyText.setText(langModel.getNo());
    holder.languageText.setText(langModel.getLangage());
    holder.countryText.setText(langModel.getCountyry());

    }

    @Override
    public int getItemCount(){
    return languageList.size();
    }

}
