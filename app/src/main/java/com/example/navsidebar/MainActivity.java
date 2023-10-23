package com.example.navsidebar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.Button;
import androidx.cardview.widget.CardView;
import android.view.MenuItem;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.widget.Toolbar;
import com.google.android.material.navigation.NavigationView;


public class MainActivity extends AppCompatActivity {

    private CardView firm1,firm2;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ActionBarDrawerToggle drawerToggle;
    Toolbar toolbar;



    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (drawerToggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firm1 = findViewById(R.id.firm1);
        firm1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openFirm1();
            }
        });
        firm2 = findViewById(R.id.firm2);
        firm2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openFirm2();
            }
        });









        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        drawerToggle = new ActionBarDrawerToggle(this,drawerLayout,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

                @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();
                if (itemId == R.id.home) {
                    Toast.makeText(MainActivity.this, "Home Selected", Toast.LENGTH_SHORT).show();
                    Intent intent1 = new Intent(MainActivity.this, MainActivity.class);


                    startActivity(intent1);

                    finish();
                    return true;

                } else if (itemId == R.id.account) {
                    Toast.makeText(MainActivity.this, "Account Selected", Toast.LENGTH_SHORT).show();
                } else if (itemId == R.id.help) {
                    Toast.makeText(MainActivity.this, "Help Selected", Toast.LENGTH_SHORT).show();
                } else if (itemId == R.id.about) {
                    Toast.makeText(MainActivity.this, "About Us Selected", Toast.LENGTH_SHORT).show();
                } else if (itemId == R.id.logout) {
                    Toast.makeText(MainActivity.this, "Log out Selected", Toast.LENGTH_SHORT).show();
                } else if (itemId == R.id.share) {
                    Toast.makeText(MainActivity.this, "Share Selected", Toast.LENGTH_SHORT).show();
                } else if (itemId == R.id.rate) {
                    Toast.makeText(MainActivity.this, "Rate Us Selected", Toast.LENGTH_SHORT).show();
                }
                return false;
            }
        });
    }


    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);

        }
         else {
            super.onBackPressed();
        }
    }
    public void openFirm1(){
        Intent intent = new Intent(this, build1.class);
        startActivity(intent);
    }
    public void openFirm2(){
        Intent intent = new Intent(this, build2.class);
        startActivity(intent);
    }
    public void openToolbar(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}