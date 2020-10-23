package com.example.listviewcontent;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class CustomAdapter  extends ArrayAdapter {
    Activity activity;
    int layout;
    ArrayList<sinhvien> arrSinhvien;

    public CustomAdapter(@NonNull Activity activity, int layout, @NonNull ArrayList<sinhvien> arrSinhvien) {
        super(activity, layout, arrSinhvien);
        this.activity=activity;
        this.layout=layout;
        this.arrSinhvien=arrSinhvien;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater=activity.getLayoutInflater();
        convertView=layoutInflater.inflate(layout,null);
        ImageView avatar=convertView.findViewById(R.id.avatar);
        TextView ten=convertView.findViewById(R.id.text_ten);
        TextView sdt=convertView.findViewById(R.id.text_sdt);

        avatar.setImageResource(arrSinhvien.get(position).getAvatar());
        ten.setText(arrSinhvien.get(position).getTenSinhvien());
        sdt.setText(arrSinhvien.get(position).getSdtSinhvien());
        return convertView;
    }
}
