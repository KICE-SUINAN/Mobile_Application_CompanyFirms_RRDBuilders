package com.example.navsidebar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
//import android.support.v4.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.Toast;
import android.os.Bundle;

import com.google.android.material.navigation.NavigationView;

public class RateUs extends AppCompatActivity {

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ActionBarDrawerToggle drawerToggle;
    Toolbar toolbar;

    ImageView facebook,twitter,instagram;
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
        setContentView(R.layout.activity_rate_us);

        RatingBar star = findViewById(R.id.star);
        star.setRating(2.5f);
        star.setStepSize(0.5f);

        star.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                Toast.makeText(RateUs.this, "Rating: " + rating, Toast.LENGTH_SHORT).show();
            }
        });

        facebook = findViewById(R.id.facebook);
        twitter = findViewById(R.id.twitter);
        instagram = findViewById(R.id.instagram);


        twitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTwitter("https://www.twitter.com");
            }

            private void openTwitter(String s) {
                Uri webpage = Uri.parse(s);
                Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
            }


        });
        facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFacebook("https://www.facebook.com/i.rishieeeeeee");
            }

            private void openFacebook(String s) {
                Uri webpage = Uri.parse(s);
                Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
            }
        });
        instagram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openInstagram("https://www.instagram.com/irishieeeee_");
            }

            private void openInstagram(String s) {
                Uri webpage = Uri.parse(s);
                Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
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
                    Toast.makeText(RateUs.this, "Home Selected", Toast.LENGTH_SHORT).show();
                    Intent intent1 = new Intent(RateUs.this, MainActivity.class);
                    startActivity(intent1);
                    finish();
                    return true;

                } else if (itemId == R.id.account) {
                    Toast.makeText(RateUs.this, "Account Selected", Toast.LENGTH_SHORT).show();

                } else if (itemId == R.id.help) {
                    Toast.makeText(RateUs.this, "Help Selected", Toast.LENGTH_SHORT).show();
                    Intent intent1 = new Intent(RateUs.this, Help.class);
                    startActivity(intent1);
                    finish();
                    return true;

                } else if (itemId == R.id.about) {
                    Toast.makeText(RateUs.this, "About Us Selected", Toast.LENGTH_SHORT).show();
                    Intent intent1 = new Intent(RateUs.this, AboutUs.class);
                    startActivity(intent1);
                    finish();
                    return true;

                } else if (itemId == R.id.logout) {
                    Toast.makeText(RateUs.this, "Log out Selected", Toast.LENGTH_SHORT).show();

                } else if (itemId == R.id.share) {
                    Toast.makeText(RateUs.this, "Share Selected", Toast.LENGTH_SHORT).show();
                    Intent shareIntent = new Intent(Intent.ACTION_SEND);
                    shareIntent.setType("text/plain");
                    String shareText = "Promote RRD Builders on various platforms";
                    shareIntent.putExtra(Intent.EXTRA_TEXT, shareText);
                    Intent chooser = Intent.createChooser(shareIntent, "Share via");
                    startActivity(chooser);
                    return true;

                } else if (itemId == R.id.rate) {
                    Toast.makeText(RateUs.this, "Rate Us Selected", Toast.LENGTH_SHORT).show();
                    Intent intent1 = new Intent(RateUs.this, RateUs.class);
                    startActivity(intent1);
                    finish();
                    return true;
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

}