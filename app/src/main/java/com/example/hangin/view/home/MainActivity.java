package com.example.hangin.view.home;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.hangin.R;

import com.example.hangin.view.home.homeFragment.HomeFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;


import static com.example.hangin.utilities.Utility.openFragment;


public class MainActivity extends AppCompatActivity {


    BottomNavigationView bottomNaviView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        bottomNaviView = findViewById(R.id.main_nav_navigationView);
        bottomNaviView.setOnNavigationItemSelectedListener(navListener);
        openFragment(getSupportFragmentManager(), new HomeFragment(), R.id.main__fl_container);

    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                    Fragment selectedFragment = null;
                    switch (menuItem.getItemId()) {

                        case R.id.nav_home:
                            openFragment(getSupportFragmentManager(), new HomeFragment(), R.id.main__fl_container);
                            break;
                        case R.id.nav_add:
                            openFragment(getSupportFragmentManager(), new AddFragment(), R.id.main__fl_container);
                            break;

                        case R.id.nav_trends:
                            openFragment(getSupportFragmentManager(), new TrendsFragment(), R.id.main__fl_container);
                            break;
                        case R.id.nav_search:
                            openFragment(getSupportFragmentManager(),
                                    new SearchFragment(), R.id.main__fl_container);
                            break;
                    }
                    return true;
                }
            };
}
