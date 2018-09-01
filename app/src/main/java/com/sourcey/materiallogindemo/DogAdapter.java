package com.sourcey.materiallogindemo;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by mac on 30/08/18.
 * Check out by Nikhil
 */

public class DogAdapter extends RecyclerView.Adapter<DogAdapter.ViewHolder> {

    private Context context;
    private List <Dog> list;

    public DogAdapter(Context context, List<Dog> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public DogAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.single_item,parent,false);
        return new ViewHolder(v);

    }

    @Override
    public void onBindViewHolder(@NonNull DogAdapter.ViewHolder holder, int position) {

        Dog dog = list.get(position);
         holder.textbreed.setText(dog.getBreed());
         holder.textLifeSpan.setText(dog.getLifeSpan());
         holder.textInfo.setText(dog.getDogInfo());
         holder.textDogColor.setText(dog.getDogInfo());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView textbreed,textInfo,textLifeSpan,textDogColor;
        public ViewHolder(View itemView) {
            super(itemView);
            textbreed=itemView.findViewById(R.id.main_breed);
            textDogColor=itemView.findViewById(R.id.main_dogColor);
            textInfo=itemView.findViewById(R.id.main_dogInfo);
            textLifeSpan=itemView.findViewById(R.id.main_lifespan);
        }
    }
}
