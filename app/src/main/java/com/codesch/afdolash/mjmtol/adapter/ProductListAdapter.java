package com.codesch.afdolash.mjmtol.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.codesch.afdolash.mjmtol.R;
import com.codesch.afdolash.mjmtol.activity.ProductDetailActivity;
import com.codesch.afdolash.mjmtol.model.Product;
import com.codesch.afdolash.mjmtol.model.Umkm;
import com.codesch.afdolash.mjmtol.services.ApiService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Afdolash on 11/7/2017.
 */

public class ProductListAdapter extends RecyclerView.Adapter<ProductListAdapter.MyViewHolder> {

    private Context context;
    private List<Product> productList = new ArrayList<>();

    public ProductListAdapter(Context context, List<Product> productList) {
        this.context = context;
        this.productList = productList;
    }

    @Override
    public ProductListAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_product_list, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ProductListAdapter.MyViewHolder holder, int position) {
        RequestOptions options = new RequestOptions()
                .centerCrop()
                .placeholder(R.mipmap.ic_launcher_round)
                .error(R.mipmap.ic_launcher_round);

        final Product product = productList.get(position);

        Glide.with(context).load(product.getFoto_produk()).apply(options).into(holder.imgProduct);
        holder.tvTitle.setText(product.getNama_produk());
        holder.tvPrice.setText(String.valueOf(product.getHarga_produk()));
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ProductDetailActivity.class);
                intent.putExtra("id_produk", product.getId_produk());
                context.startActivity(intent);
            }
        });

        ApiService.service_post.postDetailUmkm(product.getId_umkm()).enqueue(new Callback<Umkm>() {
            @Override
            public void onResponse(Call<Umkm> call, Response<Umkm> response) {
                Umkm umkm = response.body();

                holder.tvUmkm.setText(umkm.getNama_umkm());
            }

            @Override
            public void onFailure(Call<Umkm> call, Throwable t) {
            }
        });
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public LinearLayout linearLayout;
        public ImageView imgProduct;
        public TextView tvTitle, tvPrice, tvUmkm;

        public MyViewHolder(View itemView) {
            super(itemView);

            linearLayout = (LinearLayout) itemView.findViewById(R.id.linear_layout);
            imgProduct = (ImageView) itemView.findViewById(R.id.img_product);
            tvTitle = (TextView) itemView.findViewById(R.id.tv_title);
            tvPrice = (TextView) itemView.findViewById(R.id.tv_price);
            tvUmkm = (TextView) itemView.findViewById(R.id.tv_umkm);
        }
    }
}
