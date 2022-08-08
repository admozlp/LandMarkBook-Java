package com.ademozalp.landmarkbookjava;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ademozalp.landmarkbookjava.databinding.RecyclerRowBinding;

import java.util.ArrayList;

public class LandmarkAdapter extends RecyclerView.Adapter<LandmarkAdapter.LandmarHolder> {
    ArrayList<Landmark> landmarkArrayList;

    public LandmarkAdapter(ArrayList<Landmark> landmarkArrayList) {
        this.landmarkArrayList = landmarkArrayList;
    }

    @NonNull
    @Override
    public LandmarHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerRowBinding recyclerRowBinding = RecyclerRowBinding.inflate(LayoutInflater.from(parent.getContext()), parent,false);
        return new LandmarHolder(recyclerRowBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull LandmarHolder holder, int position) {
        holder.binding.receyclerViewTextView.setText(landmarkArrayList.get(position).name);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // singleton ile veriyi göndermek
                Singleton singleton = Singleton.getInstance();
                singleton.setSentLandmark(landmarkArrayList.get(position));

                // intent ile
                Intent intent = new Intent(holder.itemView.getContext(),Details.class);
                //intent.putExtra("landmark",landmarkArrayList.get(position));
                holder.itemView.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return landmarkArrayList.size();
    }

    public class LandmarHolder extends RecyclerView.ViewHolder{
        private RecyclerRowBinding binding;
        public LandmarHolder(RecyclerRowBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
