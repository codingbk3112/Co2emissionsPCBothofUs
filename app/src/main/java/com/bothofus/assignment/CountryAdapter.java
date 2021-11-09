package com.bothofus.assignment;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bothofus.assignment.model.Response;
import com.google.gson.Gson;

import java.util.ArrayList;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.ViewHolder> {

    public ArrayList<Response.Country> countries = new ArrayList<>();
    private Context context;
    private LayoutInflater layoutInflater;

    public CountryAdapter(ArrayList<Response.Country> countries, Context context) {
        this.countries = countries;
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.item_countries, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Response.Country  country = countries.get(position);
        holder.tvCountryName.setText(country.getName());
        holder.cardView.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(context,SecondActivity.class);
                        intent.putExtra("name",country.getName());
                        intent.putExtra("co2",country.getEmission());
                        context.startActivity(intent);
                    }
                }
        );

    }

    @Override
    public int getItemCount() {
        return countries.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
            TextView tvCountryName;
            CardView cardView;

        public ViewHolder(View itemView) {
            super(itemView);
            tvCountryName = (TextView) itemView.findViewById(R.id.tvCountryName);
            cardView = itemView.findViewById(R.id.cardView);
        }
    }
}