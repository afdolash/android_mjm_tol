package com.codesch.afdolash.mjmtol.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.codesch.afdolash.mjmtol.R;
import com.codesch.afdolash.mjmtol.adapter.ProductAdapter;
import com.codesch.afdolash.mjmtol.model.Product;
import com.codesch.afdolash.mjmtol.model.ProductDetail;
import com.codesch.afdolash.mjmtol.model.Umkm;
import com.codesch.afdolash.mjmtol.services.ApiService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductDetailActivity extends AppCompatActivity {

    private TextView tvTitle, tvPrice, tvNameUmkm, tvKontakUmkm, tvDescription, tvReadMore, tvMoreProduct;
    private ImageView imgProduct, imgUmkm;
    private RecyclerView recyclerProduct;
    private RequestOptions options;

    private int ID_PRODUCT;

    private ProductDetail product;
    private Umkm umkm;

    private ProductAdapter mProductAdapter;

    private List<Product> mProductList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);

        ID_PRODUCT = getIntent().getIntExtra("id_produk", 0);

        tvTitle = (TextView) findViewById(R.id.tv_title);
        tvPrice = (TextView) findViewById(R.id.tv_price);
        tvNameUmkm = (TextView) findViewById(R.id.tv_name_umkm);
        tvKontakUmkm = (TextView) findViewById(R.id.tv_kontak_umkm);
        tvDescription = (TextView) findViewById(R.id.tv_description);
        tvReadMore = (TextView) findViewById(R.id.tv_readMore);
        tvMoreProduct = (TextView) findViewById(R.id.tv_moreProduct);
        imgProduct = (ImageView) findViewById(R.id.img_product);
        imgUmkm = (ImageView) findViewById(R.id.img_umkm);
        recyclerProduct = (RecyclerView) findViewById(R.id.recycler_product);

        options = new RequestOptions()
                .centerCrop()
                .placeholder(R.mipmap.ic_launcher_round)
                .error(R.mipmap.ic_launcher_round);

        ApiService.service_post.postDetailProduct(ID_PRODUCT).enqueue(new Callback<ProductDetail>() {
            @Override
            public void onResponse(Call<ProductDetail> call, Response<ProductDetail> response) {
                product = response.body();

                tvTitle.setText(product.getNama_produk());
                tvPrice.setText(String.valueOf(product.getHarga_produk()));
                tvDescription.setText(product.getDeskripsi_produk());
                tvNameUmkm.setText(product.getId_umkm().getNama_umkm());
                tvKontakUmkm.setText(product.getId_umkm().getKontak_umkm());
                Glide.with(ProductDetailActivity.this).load(product.getFoto_produk()).apply(options).into(imgProduct);
                Glide.with(ProductDetailActivity.this).load(product.getId_umkm().getFoto_umkm()).apply(options).into(imgUmkm);

                imgUmkm.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(ProductDetailActivity.this, UmkmDetailActivity.class);
                        intent.putExtra("id_umkm", product.getId_umkm().getId_umkm());
                        startActivity(intent);
                    }
                });
            }

            @Override
            public void onFailure(Call<ProductDetail> call, Throwable t) {
            }
        });

        // Product Recycler View
        RecyclerView.LayoutManager mProductManager = new LinearLayoutManager(ProductDetailActivity.this, LinearLayoutManager.HORIZONTAL, false);

        recyclerProduct.setLayoutManager(mProductManager);
        recyclerProduct.setItemAnimator(new DefaultItemAnimator());
        recyclerProduct.setAdapter(mProductAdapter);

        ApiService.service_get.getListProduct().enqueue(new Callback<ArrayList<Product>>() {
            @Override
            public void onResponse(Call<ArrayList<Product>> call, Response<ArrayList<Product>> response) {
                mProductList = response.body()  ;
                mProductAdapter = new ProductAdapter(ProductDetailActivity.this, mProductList);
                recyclerProduct.setAdapter(mProductAdapter);
                mProductAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<ArrayList<Product>> call, Throwable t) {
                Toast.makeText(ProductDetailActivity.this,"Mohon maaf terjadi gangguan dengan jaringan Anda", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
