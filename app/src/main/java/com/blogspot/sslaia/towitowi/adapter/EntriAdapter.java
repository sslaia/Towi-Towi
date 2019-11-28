package com.blogspot.sslaia.towitowi.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.blogspot.sslaia.towitowi.R;
import com.blogspot.sslaia.towitowi.db.Towi;

import java.util.ArrayList;
import java.util.List;

public class EntriAdapter extends RecyclerView.Adapter<EntriAdapter.EntriHolder> {
    private List<Towi> entries = new ArrayList<>();

    @NonNull
    @Override
    public EntriHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyclerview_items, parent, false);
        return new EntriHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull EntriHolder holder, int position) {
        Towi currentEntri = entries.get(position);
        holder.title.setText(currentEntri.getTitle());
//        holder.image.setImageResource(currentEntri.getImage());
    }

    @Override
    public int getItemCount() {
        return entries.size();
    }

    public void setEntries(List<Towi> entries) {
        this.entries = entries;
        notifyDataSetChanged();
    }

    class EntriHolder extends RecyclerView.ViewHolder {
        private TextView title;
        private TextView label;
        private TextView body;
//        private ImageView image;

        public EntriHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.entri_title);
            label = itemView.findViewById(R.id.entri_label);
            body = itemView.findViewById(R.id.entri_body);
//            image = itemView.findViewById(R.id.entri_image);
        }
    }
}
