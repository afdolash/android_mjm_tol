package com.codesch.afdolash.mjmtol.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.codesch.afdolash.mjmtol.R;
import com.codesch.afdolash.mjmtol.adapter.CategoryAdapter;
import com.codesch.afdolash.mjmtol.adapter.ProductAdapter;
import com.codesch.afdolash.mjmtol.model.Product;
import com.codesch.afdolash.mjmtol.services.ApiService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    private RecyclerView recyclerCategory, recyclerProduct;

    private CategoryAdapter mCategoryAdapter;
    private ProductAdapter mProductAdapter;

    private List<Product> mProductList = new ArrayList<>();

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_beranda, container, false);

        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);

        recyclerCategory = (RecyclerView) view.findViewById(R.id.recycler_category);
        recyclerProduct = (RecyclerView) view.findViewById(R.id.recycler_product);

        // Category Recycler View
        mCategoryAdapter = new CategoryAdapter(getActivity());
        RecyclerView.LayoutManager mCategoryManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);

        recyclerCategory.setLayoutManager(mCategoryManager);
        recyclerCategory.setItemAnimator(new DefaultItemAnimator());
        recyclerCategory.setAdapter(mCategoryAdapter);

        // Product Recycler View
        RecyclerView.LayoutManager mProductManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);

        recyclerProduct.setLayoutManager(mProductManager);
        recyclerProduct.setItemAnimator(new DefaultItemAnimator());
        recyclerProduct.setAdapter(mProductAdapter);

        ApiService.service_get.getListProduct().enqueue(new Callback<ArrayList<Product>>() {
            @Override
            public void onResponse(Call<ArrayList<Product>> call, Response<ArrayList<Product>> response) {
                mProductList = response.body()  ;
                mProductAdapter = new ProductAdapter(getContext(), mProductList);
                recyclerProduct.setAdapter(mProductAdapter);
                mProductAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<ArrayList<Product>> call, Throwable t) {
                Toast.makeText(getActivity(),"Mohon maaf terjadi gangguan dengan jaringan Anda", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}
