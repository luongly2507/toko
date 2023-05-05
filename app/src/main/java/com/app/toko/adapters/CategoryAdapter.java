package com.app.toko.adapters;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.app.toko.R;
import com.app.toko.responses.CategoryResponse;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {
    private Context context;
    private ArrayList<CategoryResponse> categories;

    public CategoryAdapter(Context context, ArrayList<CategoryResponse> categories) {
        this.context = context;
        this.categories = categories;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View itemView = inflater.inflate(R.layout.recycler_view_custom_category_items, parent, false);
        ViewHolder viewHolder = new ViewHolder(itemView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        CategoryResponse category = categories.get(position);

        Glide.with(context)
                .load(category.getImageSource())
                .into(holder.categoryImage);
        holder.categoryName.setText(category.getName());
    }

    @Override
    public int getItemCount() {
        if (categories != null) {
            return categories.size();
        }
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView categoryImage;
        private TextView categoryName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            categoryImage = itemView.findViewById(R.id.recycler_view_custom_category_items_image);
            categoryName = itemView.findViewById(R.id.recycler_view_custom_category_items_text);

        }
    }
}
