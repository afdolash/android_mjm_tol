package com.codesch.afdolash.mjmtol.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.codesch.afdolash.mjmtol.R;
import com.codesch.afdolash.mjmtol.model.Umkm;
import com.codesch.afdolash.mjmtol.services.ApiService;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.miguelcatalan.materialsearchview.MaterialSearchView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class MapsFragment extends Fragment implements OnMapReadyCallback {

    private MaterialSearchView searchView;
    private GoogleMap mGoogleMap;
    private MapView mMapView;

    private List<Umkm> mUmkmList = new ArrayList<>();

    public MapsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_maps, container, false);

        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        setHasOptionsMenu(true);

        mMapView = (MapView) view.findViewById(R.id.mapView);
        mMapView.onCreate(savedInstanceState);
        mMapView.getMapAsync(this);
        mMapView.onResume(); // needed to get the map to display immediately

        try {
            MapsInitializer.initialize(getActivity().getApplicationContext());
        } catch (Exception e) {
            e.printStackTrace();
        }

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

        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_search, menu);

        MenuItem item = menu.findItem(R.id.nav_search);
        searchView.setMenuItem(item);

        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mGoogleMap = googleMap;
        mGoogleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

        ApiService.service_get.getListUmkm().enqueue(new Callback<ArrayList<Umkm>>() {
            @Override
            public void onResponse(Call<ArrayList<Umkm>> call, Response<ArrayList<Umkm>> response) {
                mUmkmList = response.body()  ;

                for (Umkm umkm : mUmkmList) {
                    double umkmLat = umkm.getLatitude_umkm();
                    double umkmLng = umkm.getLongitude_umkm();

                    LatLng umkmLatLng = new LatLng(umkmLat, umkmLng);

                    mGoogleMap.addMarker(new MarkerOptions()
                            .position(umkmLatLng)
                            .title(umkm.getNama_umkm()));

                    Toast.makeText(getActivity(), umkmLatLng.toString(), Toast.LENGTH_SHORT).show();

                    LatLng sydney = new LatLng(-7.269607, 112.781460);
                    mGoogleMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Umkm>> call, Throwable t) {
                Toast.makeText(getActivity(),"Mohon maaf terjadi gangguan dengan jaringan Anda", Toast.LENGTH_SHORT).show();
            }
        });

        // Add a marker in Sydney, Australia, and move the camera


//        CameraPosition cameraPosition = new CameraPosition.Builder().target(sydney).zoom(12).build();
//        mGoogleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mMapView.onLowMemory();
    }
}
