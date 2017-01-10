package com.kenyaweb.kenyawebapp.services;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.kenyaweb.kenyawebapp.R;

/**
 * Created by nabwera_taracha on 5/25/16.
 */
public class SEO extends AppCompatActivity {

    Toolbar toolbar = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soe);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        //Initialize ImageView
        ImageView imageView = (ImageView) findViewById(R.id.backdrop);

        //Loading image from below url into imageView
        Glide.with(this)
                .load("http://newsite.co.ke/mobile/mobile_app_assets/seo.png")
                .placeholder(R.drawable.placeholder1)
                .error(R.drawable.placeholder1)
                .into(imageView);

    }

    @Override
    public boolean onOptionsItemSelected(final MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
