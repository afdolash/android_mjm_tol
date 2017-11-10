package com.codesch.afdolash.mjmtol.activity;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.codesch.afdolash.mjmtol.R;
import com.codesch.afdolash.mjmtol.fragment.HomeFragment;
import com.codesch.afdolash.mjmtol.fragment.MapsFragment;
import com.codesch.afdolash.mjmtol.fragment.ProfileFragment;
import com.codesch.afdolash.mjmtol.fragment.UmkmFragment;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out)
                    .replace(R.id.tab_content, new HomeFragment())
                    .commit();
        }

        bottomNavigationView = (BottomNavigationView) findViewById(R.id.tab_layout);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment = null;

                switch (item.getItemId()) {
                    case R.id.nav_home:
                        fragment = new HomeFragment();
                        break;
                    case R.id.nav_maps:
                        fragment = new MapsFragment();
                        break;
                    case R.id.nav_umkm:
                        fragment = new UmkmFragment();
                        break;
                    case R.id.nav_profile:
                        fragment = new ProfileFragment();
                        break;
                    default:
                        fragment = new HomeFragment();
                        break;
                }

                getSupportFragmentManager().beginTransaction()
                        .setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out)
                        .replace(R.id.tab_content, fragment)
                        .commit();

                return true;
            }
        });
    }
}
