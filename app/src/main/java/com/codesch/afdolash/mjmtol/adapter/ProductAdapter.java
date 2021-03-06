package com.codesch.afdolash.mjmtol.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.codesch.afdolash.mjmtol.R;
import com.codesch.afdolash.mjmtol.model.Product;
import com.codesch.afdolash.mjmtol.model.Umkm;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Afdolash on 11/7/2017.
 */

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.MyViewHolder> {

    private Context context;
    private List<Product> productList = new ArrayList<>();

    public ProductAdapter(Context context, List<Product> productList) {
        this.context = context;
        this.productList = productList;
    }

    @Override
    public ProductAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_product, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ProductAdapter.MyViewHolder holder, int position) {
        RequestOptions options = new RequestOptions()
                .centerCrop()
                .placeholder(R.mipmap.ic_launcher_round)
                .error(R.mipmap.ic_launcher_round);

        Product product = productList.get(position);

        Glide.with(context).load(product.getFoto_produk()).apply(options).into(holder.imgProduct);
        holder.tvTitle.setText(product.getNama_produk());
        holder.tvPrice.setText(String.valueOf(product.getHarga_produk()));
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public LinearLayout linearLayout;
        public ImageView imgProduct;
        public TextView tvPrice, tvTitle;

        public MyViewHolder(View itemView) {
            super(itemView);

            linearLayout = (LinearLayout) itemView.findViewById(R.id.linear_layout);
            imgProduct = (ImageView) itemView.findViewById(R.id.img_product);
            tvTitle = (TextView) itemView.findViewById(R.id.tv_title);
            tvPrice = (TextView) itemView.findViewById(R.id.tv_price);
        }
    }
}
