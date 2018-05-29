package com.reinhardjs.dsc_training.RecyclerView;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.transition.Fade;
import android.transition.Slide;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.reinhardjs.dsc_training.Fragments.FragmentDetail;
import com.reinhardjs.dsc_training.Fragments.FragmentRV;
import com.reinhardjs.dsc_training.R;

import java.util.ArrayList;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.ViewHolder> {

    private Context mContext;
    private ArrayList<DummyData> dataList;
    private FragmentManager fragmentManager;

    public RVAdapter(Context context, ArrayList<DummyData> dataList, FragmentManager fragmentManager){
        mContext = context;
        this.dataList = dataList;
        this.fragmentManager = fragmentManager;
    }


    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.recyclerview_item, parent, false);
        return new RVAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        int pos = holder.getLayoutPosition();
        final int imageResId = dataList.get(pos).getImageResId();
        final String content = dataList.get(pos).getContent();
        holder.imageView.setImageResource(imageResId);
        holder.content.setText(content);
        holder.container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fragmentTransaction;
                fragmentTransaction = fragmentManager.beginTransaction();

                Bundle bundle = new Bundle();
                bundle.putInt("IMAGE_RES_ID", imageResId);
                bundle.putString("CONTENT", content);

                FragmentDetail fragmentDetail = new FragmentDetail();
                fragmentDetail.setEnterTransition(new Slide(Gravity.RIGHT));
                fragmentDetail.setAllowEnterTransitionOverlap(false);
                fragmentDetail.setArguments(bundle);

                fragmentTransaction.replace(R.id.fragment, fragmentDetail, "Fragment Detail");
                fragmentTransaction.addToBackStack("FragmentDetail");
                fragmentTransaction.commit();
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        View container;
        ImageView imageView;
        TextView content;

        ViewHolder(View view){
            super(view);
            container = view.findViewById(R.id.container);
            imageView = view.findViewById(R.id.imageView);
            content = view.findViewById(R.id.textView);
        }
    }
}
