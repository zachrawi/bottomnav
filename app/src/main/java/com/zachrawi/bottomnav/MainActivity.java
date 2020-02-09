package com.zachrawi.bottomnav;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Switch;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottomNav);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frameLayout, MyFragment.newInstance(R.color.colorAccent, "Home"))
                .commit();

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment = null;

                switch (item.getItemId()) {
                    case R.id.nav_home:
                        fragment = MyFragment.newInstance(R.color.colorAccent, "Home");
                        break;

                    case R.id.nav_favorites:
                        fragment = MyFragment.newInstance(R.color.colorPrimary, "Favorites");
                        break;

                    case R.id.nav_search:
                        fragment = MyFragment.newInstance(R.color.colorPrimaryDark, "Search");
                        break;

                    case R.id.nav_share:
                        Intent share = new Intent(Intent.ACTION_SEND);
                        share.setType("text/plain");
                        share.putExtra(Intent.EXTRA_SUBJECT, "Title Of The Post");
                        share.putExtra(Intent.EXTRA_TEXT, "http://www.codeofaninja.com");
                        startActivity(Intent.createChooser(share, "Share link!"));
                        return false;
                }

                getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, fragment).commit();

                return true;
            }
        });
    }
}
