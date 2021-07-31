package com.hllbr.landmarkbook_with_recyclerview;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hllbr.landmarkbook_with_recyclerview.databinding.RecyclerRowBinding;

import java.util.ArrayList;


public class LandmarkAdapter extends RecyclerView.Adapter<LandmarkAdapter.LandmarkHolder> {
    ArrayList<LandMark> landMarkArrayList;

    public LandmarkAdapter(ArrayList<LandMark> landMarkArrayList) {
        this.landMarkArrayList = landMarkArrayList;
    }

    @NonNull
    @Override
    public LandmarkHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerRowBinding recyclerRowBinding = RecyclerRowBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new LandmarkHolder(recyclerRowBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull LandmarkAdapter.LandmarkHolder holder, int position) {
     holder.binding.recyclerViewTextView.setText(landMarkArrayList.get(position).name);
     holder.itemView.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             Intent intent = new Intent(holder.itemView.getContext(),Details_Activity.class);
            // chosenLandmark = landMarkArrayList.get(position);//güvenli bir yntem değil
             //intent.putExtra("landmark",landMarkArrayList.get(position));
             Singledton singledton = Singledton.getInstance();
             singledton.setSentLandmark(landMarkArrayList.get(position));
             holder.itemView.getContext().startActivity(intent);
         }
     });
    }

    @Override
    public int getItemCount() {
        return landMarkArrayList.size();
    }

    public class LandmarkHolder extends RecyclerView.ViewHolder{
        private RecyclerRowBinding binding;
        public LandmarkHolder(RecyclerRowBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
        //Görünümlerimizi tutan yardımcı bir sınıf
    }
}
