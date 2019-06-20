package com.example.mobileshoptest.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mobileshoptest.R;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LeftAdapter extends RecyclerView.Adapter<LeftAdapter.ViewHolder> {
    private Context context;
    private LayoutInflater inflater;
    private List<Integer> postions = new LinkedList<>();
    private List<String> data = new ArrayList<>();
    public LeftAdapter(Context context, List<String> data1){
        data.clear();
        this.context = context;
        this.data = data1;
        inflater = LayoutInflater.from(context);
    }
    @NonNull
    @Override
    public LeftAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ViewHolder holder = null;
        View view = inflater.inflate(R.layout.left_menu_layout,parent,false);
        holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull LeftAdapter.ViewHolder holder, int position) {
        holder.mText.setText(data.get(position));
        if (position%2 == 0){
            postions.add(position);

        }
        System.out.println(postions);
        if (postions.contains(position)){
            holder.imageView.setBackground(ContextCompat.getDrawable(context,R.drawable.image));

        }else {
            holder.imageView.setBackground(ContextCompat.getDrawable(context,R.drawable.ic_launcher_background));
        }

    }



    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.text_left)
        TextView mText;
        @BindView(R.id.left_image)
        ImageView imageView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
