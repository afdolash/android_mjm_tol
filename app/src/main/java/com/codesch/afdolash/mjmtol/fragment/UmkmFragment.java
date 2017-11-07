package com.codesch.afdolash.mjmtol.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.codesch.afdolash.mjmtol.R;
import com.codesch.afdolash.mjmtol.adapter.ProductListAdapter;
import com.codesch.afdolash.mjmtol.model.Product;
import com.miguelcatalan.materialsearchview.MaterialSearchView;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class UmkmFragment extends Fragment {

    private MaterialSearchView searchView;
    private RecyclerView recyclerProduct;

    private ProductListAdapter mProductListAdapter;

    private List<Product> mProductList = new ArrayList<>();

    public UmkmFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_umkm, container, false);

        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        setHasOptionsMenu(true);

        recyclerProduct = (RecyclerView) view.findViewById(R.id.recycler_product);
        searchView = (MaterialSearchView) view.findViewById(R.id.search_view);

        searchView.setOnQueryTextListener(new MaterialSearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                //Do some magic
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                //Do some magic
                return false;
            }
        });

        searchView.setOnSearchViewListener(new MaterialSearchView.SearchViewListener() {
            @Override
            public void onSearchViewShown() {
                //Do some magic
            }

            @Override
            public void onSearchViewClosed() {
                //Do some magic
            }
        });

        // Product Recycler View
        mProductListAdapter = new ProductListAdapter(getActivity(), mProductList);
        RecyclerView.LayoutManager mProductListManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);

        recyclerProduct.setLayoutManager(mProductListManager);
        recyclerProduct.setItemAnimator(new DefaultItemAnimator());
        recyclerProduct.setAdapter(mProductListAdapter);

        prepareProductData();


        return view;
    }

    void prepareProductData() {
        Product product = new Product(
                1,
                1,
                R.mipmap.ic_launcher,
                "Jagung",
                "Kg",
                "Jagung berkhasiat yang dapat menyembuhkan berbagai penyakit",
                20000.0,
                12.0
        );

        mProductList.add(product);
        mProductList.add(product);
        mProductList.add(product);
        mProductList.add(product);
        mProductList.add(product);
        mProductList.add(product);
        mProductList.add(product);
        mProductList.add(product);
        mProductList.add(product);
        mProductList.add(product);

        mProductListAdapter.notifyDataSetChanged();
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_search, menu);

        MenuItem item = menu.findItem(R.id.nav_search);
        searchView.setMenuItem(item);

        super.onCreateOptionsMenu(menu, inflater);
    }
}
