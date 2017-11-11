package com.codesch.afdolash.mjmtol.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.codesch.afdolash.mjmtol.R;
import com.codesch.afdolash.mjmtol.model.Umkm;
import com.codesch.afdolash.mjmtol.services.ApiService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UmkmDetailActivity extends AppCompatActivity {

    private TextView tvTitle, tvLocation, tvJamBuka, tvJamTutup, tvNote, tvContact;
    private Button btnNavigation;
    private ImageButton btnCall;
    private RecyclerView recyclerProduct;
    private ImageView imgUmkm;

    private RequestOptions options;
    private int ID_UMKM;

    private Umkm umkm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_umkm_detail);

        ID_UMKM = getIntent().getIntExtra("id_umkm", 0);

        tvTitle = (TextView) findViewById(R.id.tv_title);
        tvLocation = (TextView) findViewById(R.id.tv_location);
        tvJamBuka = (TextView) findViewById(R.id.tv_jamBuka);
        tvJamTutup = (TextView) findViewById(R.id.tv_jamTutup);
        tvNote = (TextView) findViewById(R.id.tv_note);
        tvContact = (TextView) findViewById(R.id.tv_contact);
        btnNavigation = (Button) findViewById(R.id.btn_navigation);
        btnCall = (ImageButton) findViewById(R.id.btn_call);
        recyclerProduct = (RecyclerView) findViewById(R.id.recycler_product);
        imgUmkm = (ImageView) findViewById(R.id.img_umkm);

        options = new RequestOptions()
                .centerCrop()
                .placeholder(R.mipmap.ic_launcher_round)
                .error(R.mipmap.ic_launcher_round);

        ApiService.service_post.postDetailUmkm(ID_UMKM).enqueue(new Callback<Umkm>() {
            @Override
            public void onResponse(Call<Umkm> call, Response<Umkm> response) {
                umkm = response.body();

                tvTitle.setText(umkm.getNama_umkm());
                tvLocation.setText(umkm.getAlamat_umkm());
                tvJamBuka.setText(umkm.getBuka_umkm());
                tvJamTutup.setText(umkm.getTutup_umkm());
                tvNote.setText(umkm.getKeterangan_umkm());
                tvContact.setText(umkm.getKontak_umkm());
                Glide.with(UmkmDetailActivity.this).load(umkm.getFoto_umkm()).apply(options).into(imgUmkm);
            }

            @Override
            public void onFailure(Call<Umkm> call, Throwable t) {
            }
        });
    }
}
