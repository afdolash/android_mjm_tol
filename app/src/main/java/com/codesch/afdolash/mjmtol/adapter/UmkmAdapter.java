package com.codesch.afdolash.mjmtol.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.codesch.afdolash.mjmtol.R;
import com.codesch.afdolash.mjmtol.model.Umkm;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Afdolash on 11/7/2017.
 */

public class UmkmAdapter extends RecyclerView.Adapter<UmkmAdapter.MyViewHolder> {

    private Context context;
    private List<Umkm> umkmList = new ArrayList<>();

    public UmkmAdapter(Context context, List<Umkm> umkmList) {
        this.context = context;
        this.umkmList = umkmList;
    }

    @Override
    public UmkmAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_umkm, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(UmkmAdapter.MyViewHolder holder, int position) {
        Umkm umkm = umkmList.get(position);
    }

    @Override
    public int getItemCount() {
        return umkmList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public LinearLayout linearLayout;
        public ImageView imgStore;
        public TextView tvCategory, tvTitle;

        public MyViewHolder(View itemView) {
            super(itemView);

            linearLayout = (LinearLayout) itemView.findViewById(R.id.linear_layout);
            imgStore = (ImageView) itemView.findViewById(R.id.img_store);
            tvTitle = (TextView) itemView.findViewById(R.id.tv_title);
            tvCategory = (TextView) itemView.findViewById(R.id.tv_category);
        }
    }
}
