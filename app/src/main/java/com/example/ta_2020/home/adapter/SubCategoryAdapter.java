package com.example.ta_2020.home.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.ta_2020.R;
import com.example.ta_2020.home.model.Category;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SubCategoryAdapter extends RecyclerView.Adapter<SubCategoryAdapter.vHolder> {

    private Context context;
    private List<Category.DataBean.SubCategoriesBean> subCategories;

    public SubCategoryAdapter(Context context, List<Category.DataBean.SubCategoriesBean> subCategories) {
        this.context = context;
        this.subCategories = subCategories;
    }

    @NonNull
    @Override
    public vHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.row_item, parent, false);
        return new vHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull vHolder holder, int position) {
        holder.txtNameRow.setText(subCategories.get(position).getSub_category_name());
        Glide.with(context)
                .load(subCategories.get(position).getImg_url())
                .centerCrop()
                .into(holder.imgRow);
        holder.cardViewRow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }

    @Override
    public int getItemCount() {
        return (subCategories != null ? subCategories.size() : 0);
    }

    public class vHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.imgRow)
        ImageView imgRow;
        @BindView(R.id.txtNameRow)
        TextView txtNameRow;
        @BindView(R.id.cardViewRow)
        CardView cardViewRow;
        public vHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
