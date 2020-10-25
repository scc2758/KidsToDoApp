package com.example.kidstodoapp;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

// Uses example from https://guides.codepath.com/android/using-the-recyclerview

public class TrophyAdapter extends RecyclerView.Adapter<TrophyAdapter.ViewHolder> {

    private List<Trophy> mTrophies;
    private OnEntryListener mOnEntryListener;

    public static final int ITEM_TYPE_NO_EDIT = 0;
    public static final int ITEM_TYPE_EDIT = 1;
    private int VIEW_TYPE = 0;

    public TrophyAdapter(List<Trophy> trophies, OnEntryListener onEntryListener) {
        this.mTrophies = trophies;
        this.mOnEntryListener = onEntryListener;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView nameTextView;
        public TextView descriptionTextView;
        public OnEntryListener onEntryListener;
        public ImageButton editTrophyButton;

        public ViewHolder(View view, OnEntryListener onEntryListener) {
            super(view);

            nameTextView = itemView.findViewById(R.id.entry_name);
           // descriptionTextView = itemView.findViewById(R.id.entry_description);
            editTrophyButton = itemView.findViewById(R.id.edit_entry_button);

            this.onEntryListener = onEntryListener;

            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            onEntryListener.onEntryClick(getAdapterPosition());
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        int layout;
        if (VIEW_TYPE == ITEM_TYPE_NO_EDIT) {
            layout = R.layout.item_to_do_entry_no_edit;
        }
        else {
            layout = R.layout.item_to_do_entry_edit;
        }
        View contactView = inflater.inflate(layout, parent, false);
        return new ViewHolder(contactView, mOnEntryListener);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        Trophy entry = mTrophies.get(position);
        TextView nameTextView = viewHolder.nameTextView;
        TextView descriptionTextView = viewHolder.descriptionTextView;
        ImageButton editTrophyButton = viewHolder.editTrophyButton;

        nameTextView.setText(entry.getName());
        descriptionTextView.setText(entry.getDescription());
        editTrophyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });

        String[] colors = {"#ECCCC5", "#D2ECC5", "#C5E5EC", "#E0C5EC"};
        viewHolder.itemView.setBackgroundColor(Color.parseColor(colors[position % colors.length]));
    }
    @Override
    public int getItemCount() {
        return mTrophies.size();
    }
    public void setVIEW_TYPE(int viewType) {
        VIEW_TYPE = viewType;
        notifyDataSetChanged();
    }
    public interface OnEntryListener {
        void onEntryClick(int position);
    }

    private LayoutInflater thisInflater;
    public View getView( View convertView, ViewGroup parent){
        if (convertView == null) {
            convertView = thisInflater.inflate(R.layout.trophy_item, parent, false);
            ImageButton thumbnailImage = (ImageButton) convertView.findViewById(R.id.trophyImage);
        }
        return convertView;
    }
}