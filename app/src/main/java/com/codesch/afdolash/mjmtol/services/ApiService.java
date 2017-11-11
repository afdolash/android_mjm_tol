package com.codesch.afdolash.mjmtol.services;

import com.codesch.afdolash.mjmtol.model.Product;
import com.codesch.afdolash.mjmtol.model.ProductDetail;
import com.codesch.afdolash.mjmtol.model.Umkm;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

/**
 * Created by Afdolash on 11/10/2017.
 */

public class ApiService {
    public static String BASE_URL = "http://182.253.66.205";

    public static PostService service_post = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build().create(ApiService.PostService.class);

    public static GetService service_get = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build().create(ApiService.GetService.class);

    public static DeleteService service_delete = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build().create(ApiService.DeleteService.class);

    public interface PostService {
        @FormUrlEncoded
        @POST("/api_mjm_tol/index.php/Master/detail_umkm_test")
        Call<Umkm> postDetailUmkm(@Field("id_umkm") int id_umkm);

        @FormUrlEncoded
        @POST("/api_mjm_tol/index.php/Master/detail_produk_test")
        Call<ProductDetail> postDetailProduct(@Field("id_produk") int id_produk);
    }

    public interface GetService {
        @GET("/api_mjm_tol/index.php/Master/all_produk_test")
        Call<ArrayList<Product>> getListProduct();

        @GET("/api_mjm_tol/index.php/Master/all_umkm_test")
        Call<ArrayList<Umkm>> getListUmkm();
    }

    public interface DeleteService {

    }
}
