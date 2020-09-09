package com.example.ta_2020.home.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.ta_2020.R;
import com.example.ta_2020.home.model.Jasa;
import com.example.ta_2020.interfaces.ProductJasaInterface;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;

public class JasaAdapter extends RecyclerView.Adapter<JasaAdapter.vHolder> {

    private Context context;
    private List<Jasa.DataBean.JasasBean> dataBeans;
    private ProductJasaInterface productJasaInterface;

    private int lastSelectedPosition = -1;

    public JasaAdapter(Context context, List<Jasa.DataBean.JasasBean> dataBeans, ProductJasaInterface productJasaInterface) {
        this.context = context;
        this.dataBeans = dataBeans;
        this.productJasaInterface = productJasaInterface;
    }

    @NonNull
    @Override
    public vHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.row_item_jasa, parent, false);
        return new vHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final vHolder holder, final int position) {
        holder.jasaName.setText(dataBeans.get(position).getJasa_name());
        holder.jasaPrice.setText((NumberFormat.getCurrencyInstance(new Locale("in", "ID")).format(dataBeans.get(position).getJasa_price())+""));

//        Glide.with(context)
//                .load(dataBeans.get(position).getImg_url())
//                .centerCrop()
//                .into(holder.ivCategory);
        holder.chk.setChecked(lastSelectedPosition == position);
        holder.chk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lastSelectedPosition = holder.getAdapterPosition();
                notifyDataSetChanged();
                productJasaInterface.onItemClick(position, true);
            }
        });

        if (position == 0 && lastSelectedPosition == -1){
            holder.chk.setChecked(true);
            productJasaInterface.onItemClick(position, true);
            Log.i("TAG", "onBindViewHolder: "+dataBeans.get(position).getJasa_id());
        }

    }

    @Override
    public int getItemCount() {
        return (dataBeans != null ? dataBeans.size() : 0);
    }

    public class vHolder extends RecyclerView.ViewHolder {


        @BindView(R.id.jasaName)
        TextView jasaName;
        @BindView(R.id.jasaPrice)
        TextView jasaPrice;
        @BindView(R.id.chk)
        CheckBox chk;

        public vHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

            if (lastSelectedPosition == -1){
                productJasaInterface.onItemClick(-1, false);
            }
        }
    }
}
