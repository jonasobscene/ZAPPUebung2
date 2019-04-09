package com.example.zappuebung2;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.Toast;

import java.util.List;
import java.util.Locale;

public class AdapterRecyclerView extends RecyclerView.Adapter<AdapterRecyclerView.CustomViewHolder> {
    private LayoutInflater mInflater;
    private List<String> mItems;
    private SparseBooleanArray booleanArray;

    public AdapterRecyclerView(Context context, List<String> items) {
        this.mItems = items;
        this.mInflater = LayoutInflater.from(context);
        booleanArray = new SparseBooleanArray();
        for(int i = 0; i < items.size(); i++) {
            booleanArray.append(i, false);
        }
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // TODO: add name of the row layout file
        return new CustomViewHolder(mInflater.inflate(R.layout.layout_recycler, parent, false));
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {
        // TODO: Set text depending on the current position
        holder.mCheckBox.setText(mItems.get(position));
        holder.mCheckBox.setChecked(booleanArray.get(position));
    }

    @Override
    public int getItemCount() {
        // TODO: return size of our data set
        return mItems.size();
    }

    class CustomViewHolder extends RecyclerView.ViewHolder {
        CheckBox mCheckBox;

        public CustomViewHolder(View view) {
            super(view);
            mCheckBox = view.findViewById(R.id.cb_main);
            checkBoxClick(mCheckBox);
        }

        private void checkBoxClick(CheckBox checkBox) {
            checkBox.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(view.getContext(),
                            String.format(Locale.GERMAN,
                                    "Position %d is checked %s", getLayoutPosition(), mCheckBox.isChecked()), Toast.LENGTH_SHORT).show();
                    booleanArray.append(getLayoutPosition(), !booleanArray.get(getLayoutPosition()));
                }
            });
        }
    }
}