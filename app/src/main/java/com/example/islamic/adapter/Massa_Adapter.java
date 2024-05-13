package com.example.islamic.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.islamic.R;

import java.util.ArrayList;

public class Massa_Adapter extends RecyclerView.Adapter<Massa_Adapter.viewHolder>{
    ArrayList<Integer> repeat;
    ArrayList<String>zekr;
    Context context ;

    public Massa_Adapter(ArrayList<Integer> repeat, ArrayList<String> zekr, Context context) {
        this.repeat = repeat;
        this.zekr = zekr;
        this.context = context;
    }

    @NonNull
    @Override
    public Massa_Adapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.massa_list,null,false);
        return new Massa_Adapter.viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Massa_Adapter.viewHolder holder, int position) {
        if (zekr != null && repeat != null) {
            holder.textView1.setText(zekr.get(position));
            String r= context.getString(R.string.repeat);
            holder.textView2.setText(r+" : "+repeat.get(position));
        }
    }

    @Override
    public int getItemCount() {
        if (zekr != null) {
            return zekr.size();
        } else {
            return 0;
        }
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        TextView textView1,textView2;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            textView1=itemView.findViewById(R.id.textView_zekr);
            textView2=itemView.findViewById(R.id.textView_repeat);
        }
    }
}


