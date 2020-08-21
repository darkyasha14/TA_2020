package com.example.ta_2020.order.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ta_2020.R;
import com.example.ta_2020.order.BookingDetailActivity;
import com.example.ta_2020.order.TransactionComplateActivity;
import com.example.ta_2020.order.model.TransactionComplate;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TransactionComplateAdapter extends RecyclerView.Adapter<TransactionComplateAdapter.vHolder> {

    Context context;
    List<TransactionComplate.DataBean> dataBeans;


    public TransactionComplateAdapter(Context context, List<TransactionComplate.DataBean> dataBeans) {
        this.context = context;
        this.dataBeans = dataBeans;
    }

    @NonNull
    @Override
    public vHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.row_item_complate, parent, false);
        return new vHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull vHolder vholder, final int i) {
        vholder.tvKode.setText("#"+dataBeans.get(i).getInvoice_no());
        vholder.tvTimeNDate.setText(dataBeans.get(i).getCreatedAt());
        vholder.tvMotode.setText(dataBeans.get(i).getBooking().getJasa().getJasa_name());
        vholder.tvTipe.setText(dataBeans.get(i).getBooking().getJasa().getSub_category().getSub_category_name());
        vholder.cvOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, TransactionComplateActivity.class);
                intent.putExtra("INVOICE", dataBeans.get(i).getInvoice_no());
                context.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return dataBeans.size();
    }

    public class vHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tvKodep)
        TextView tvKodep;
        @BindView(R.id.tvKode)
        TextView tvKode;
        @BindView(R.id.tvMotode)
        TextView tvMotode;
        @BindView(R.id.tvTipe)
        TextView tvTipe;
        @BindView(R.id.tvTimeNDate)
        TextView tvTimeNDate;
        @BindView(R.id.cvOrder)
        CardView cvOrder;

        public vHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
