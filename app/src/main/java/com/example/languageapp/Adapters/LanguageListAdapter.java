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

private ArrayList<Languages> languageList;
private final Context context;

public LanguageListAdapter(ArrayList<Languages> languageList, Context context){
    this.languageList = languageList;
    this.context = context;

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
    holder.countryText.setText(langModel.getCountry());
    holder.languageText.setText(langModel.getLanguage());
    }

    @Override
    public int getItemCount(){
    return languageList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView keyText, languageText, countryText;

        public ViewHolder(@NonNull View itemView){
            super(itemView);

            keyText = itemView.findViewById(R.id.keyTextView);
            countryText = itemView.findViewById(R.id.countryTextView);
            languageText = itemView.findViewById(R.id.languageTextView);
        }
    }
}
