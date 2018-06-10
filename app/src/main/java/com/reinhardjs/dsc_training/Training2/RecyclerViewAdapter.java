package com.reinhardjs.dsc_training.Training2;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.reinhardjs.dsc_training.R;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private Context mContext;
    private ArrayList<RecyclerViewData> dataList;

    public RecyclerViewAdapter(Context context, ArrayList<RecyclerViewData> dataList){
        mContext = context;
        this.dataList = dataList;
    }


    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.weather_list_item, parent, false);
        return new RecyclerViewAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        int pos = holder.getLayoutPosition();
        String city = dataList.get(pos).getCity();
        String temperature = dataList.get(pos).getTemperature();
        final int imageResId = dataList.get(pos).getImageResId();

        holder.cityTextView.setText(city);
        holder.temperatureTextView.setText(temperature + (char) 0x00B0);
        holder.temperatureImageView.setImageResource(imageResId);
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        TextView cityTextView;
        TextView temperatureTextView;
        ImageView temperatureImageView;

        ViewHolder(View view){
            super(view);
            cityTextView = view.findViewById(R.id.cityTextView);
            temperatureTextView = view.findViewById(R.id.tempTextView);
            temperatureImageView = view.findViewById(R.id.tempImageView);
        }
    }
}

