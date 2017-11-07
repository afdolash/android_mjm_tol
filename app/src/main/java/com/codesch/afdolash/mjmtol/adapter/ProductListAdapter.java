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
import com.codesch.afdolash.mjmtol.model.Product;

import java.util.ArrayList;
import java.util.List;

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
    public void onBindViewHolder(ProductListAdapter.MyViewHolder holder, int position) {
        Product product = productList.get(position);
        holder.tvTitle.setText(product.getName());
        holder.tvDesc.setText(product.getDescription());
        holder.tvPrice.setText(String.valueOf(product.getPrice()));
        holder.imgProduct.setImageResource(product.getImage());
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public LinearLayout linearLayout;
        public ImageView imgProduct;
        public TextView tvPrice, tvTitle, tvDesc;

        public MyViewHolder(View itemView) {
            super(itemView);

            linearLayout = (LinearLayout) itemView.findViewById(R.id.linear_layout);
            imgProduct = (ImageView) itemView.findViewById(R.id.img_product);
            tvTitle = (TextView) itemView.findViewById(R.id.tv_title);
            tvDesc = (TextView) itemView.findViewById(R.id.tv_description);
            tvPrice = (TextView) itemView.findViewById(R.id.tv_price);
        }
    }
}
