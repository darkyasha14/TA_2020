package com.example.ta_2020.home.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ta_2020.R;
import com.example.ta_2020.home.model.Category;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.vHolder> {

    private Context context;
    private List<Category.DataBean> categories;

    public CategoryAdapter(Context context, List<Category.DataBean> categories) {
        this.context = context;
        this.categories = categories;
    }

    @NonNull
    @Override
    public vHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.row_item_group, parent, false);
        return new vHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull vHolder holder, int position) {
      holder.tvCategoryName.setText(categories.get(position).getCategory_name());
      List<Category.DataBean.SubCategoriesBean> subCategories = categories.get(position).getSub_categories();
      SubCategoryAdapter subCategoryAdapter = new SubCategoryAdapter(context, subCategories);
      holder.rvGroup.setAdapter(subCategoryAdapter);
      holder.rvGroup.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
      holder.rvGroup.setHasFixedSize(true);
      holder.rvGroup.setNestedScrollingEnabled(false);

    }

    @Override
    public int getItemCount() {
        return (categories != null ? categories.size() : 0);
    }

    public class vHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tvCategoryName)
        TextView tvCategoryName;
        @BindView(R.id.rvGroup)
        RecyclerView rvGroup;
        public vHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
