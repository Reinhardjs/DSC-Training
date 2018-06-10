package com.reinhardjs.dsc_training.Training1.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.reinhardjs.dsc_training.R;

public class FragmentDetail extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_detail, container, false);

        Bundle args = getArguments();
        int imageResId = args.getInt("IMAGE_RES_ID");
        String content = args.getString("CONTENT");

        ImageView imageView = view.findViewById(R.id.imageView);
        TextView textView = view.findViewById(R.id.content);

        imageView.setImageResource(imageResId);
        textView.setText(content);

        return view;
    }
}
