package com.kenyaweb.kenyawebapp.services;

import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.Indicators.PagerIndicator;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;
import com.kenyaweb.kenyawebapp.R;

import java.util.HashMap;

/**
 * Created by nabwera_taracha on 5/25/16.
 */
public class LatestProducts extends AppCompatActivity implements BaseSliderView.OnSliderClickListener, ViewPagerEx.OnPageChangeListener {

    private SliderLayout mDemoSlider;

    Toolbar toolbar = null;

    Button btnSME, btnSoHo, btntShule, btntShulePrem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_latest_new);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        //Initialize ImageView
        ImageView imageView = (ImageView) findViewById(R.id.backdrop);

        //Loading image from below url into imageView
        Glide.with(this)
                .load("http://newsite.co.ke/mobile/mobile_app_assets/products.png")
                .placeholder(R.drawable.placeholder1)
                .error(R.drawable.placeholder1)
                .into(imageView);


//        btnSME = (Button) findViewById(R.id.btnSME);
//        btnSoHo = (Button) findViewById(R.id.btnSoHo);
//        btntShule = (Button) findViewById(R.id.btntShule);
//        btntShulePrem = (Button) findViewById(R.id.btntShulePrem);


//        // add listener to button
//        btnSME.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View arg0) {
//
//                // Create custom dialog object
//                final AlertDialog.Builder builder = new AlertDialog.Builder(LatestProducts.this);
//                builder.setTitle(getString(R.string.sme_dialog_title));
//                builder.setMessage(getString(R.string.sme_dialog_message));
//                builder.setPositiveButton("Close", null);
////                builder.setNegativeButton("Dunno", null);
//
//                builder.show();
//
//            }
//        });
//
//        // add listener to button
//        btnSoHo.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View arg1) {
//
//                // Create custom dialog object
//                final AlertDialog.Builder builder = new AlertDialog.Builder(LatestProducts.this);
//                builder.setTitle(getString(R.string.soho_dialog_title));
//                builder.setMessage(getString(R.string.soho_dialog_message));
//                builder.setPositiveButton("Close", null);
////                builder.setNegativeButton("Dunno", null);
//
//                builder.show();
//
//            }
//
//        });
//
//        // add listener to button
//        btntShule.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View arg1) {
//
//                // Create custom dialog object
//                final AlertDialog.Builder builder = new AlertDialog.Builder(LatestProducts.this);
//                builder.setTitle(getString(R.string.tShule_dialog_title));
//                builder.setMessage(getString(R.string.tShule_dialog_message));
//                builder.setPositiveButton("Close", null);
////                builder.setNegativeButton("Dunno", null);
//
//                builder.show();
//
//            }
//
//        });
//
//        // add listener to button
//        btntShulePrem.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View arg1) {
//
//                // Create custom dialog object
//                final AlertDialog.Builder builder = new AlertDialog.Builder(LatestProducts.this);
//                builder.setTitle(getString(R.string.tShulePrem_dialog_title));
//                builder.setMessage(getString(R.string.tShulePrem_dialog_message));
//                builder.setPositiveButton("Close", null);
////                builder.setNegativeButton("Dunno", null);
//
//                builder.show();
//
//            }
//
//        });




        mDemoSlider = (SliderLayout)findViewById(R.id.slider);

//        HashMap<String,String> url_maps = new HashMap<String, String>();
//        url_maps.put("SoHo Package", "http://newsite.co.ke/mobile/mobile_app_assets/baner3.png");
//        url_maps.put("SME Hosting Package", "http://newsite.co.ke/mobile/mobile_app_assets/baner2.png");
//        url_maps.put("Tech-Shule", "http://newsite.co.ke/mobile/mobile_app_assets/baner1.png");
//        url_maps.put("Tech-Shule Premium", "http://newsite.co.ke/mobile/mobile_app_assets/baner4.png");

        HashMap<String,Integer> file_maps = new HashMap<String, Integer>();
        file_maps.put("SoHo Package",R.drawable.soho);
        file_maps.put("SME Hosting Package",R.drawable.sme);
        file_maps.put("Tech-Shule",R.drawable.tshule);
        file_maps.put("Tech-Shule Premium", R.drawable.tshuleprem);

        for(String name : file_maps.keySet()){
            TextSliderView textSliderView = new TextSliderView(this);
            // initialize a SliderLayout
            textSliderView
                    .description(name)
                    .image(file_maps.get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit)
                    .setOnSliderClickListener(this);

            //add your extra information
            textSliderView.bundle(new Bundle());
            textSliderView.getBundle()
                    .putString("extra",name);

            mDemoSlider.addSlider(textSliderView);
        }
        mDemoSlider.setPresetTransformer(SliderLayout.Transformer.Accordion);
        mDemoSlider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        mDemoSlider.setCustomAnimation(new DescriptionAnimation());
        mDemoSlider.setDuration(4000);
        mDemoSlider.addOnPageChangeListener(this);
//        ListView l = (ListView)findViewById(R.id.transformers);
//        l.setAdapter(new TransformerAdapter(this));
//        l.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                mDemoSlider.setPresetTransformer(((TextView) view).getText().toString());
//                Toast.makeText(LatestProducts.this, ((TextView) view).getText().toString(), Toast.LENGTH_SHORT).show();
//            }
//        });

    }

    @Override
    protected void onStop() {
        // To prevent a memory leak on rotation, make sure to call stopAutoCycle() on the slider before activity or fragment is destroyed
        mDemoSlider.stopAutoCycle();
        super.onStop();
    }

    @Override
    public void onSliderClick(BaseSliderView slider) {
        Toast.makeText(this,slider.getBundle().get("extra") + "",Toast.LENGTH_SHORT).show();
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        MenuInflater menuInflater = getMenuInflater();
//        menuInflater.inflate(R.menu.slider_main,menu);
//        return super.onCreateOptionsMenu(menu);
//    }

    @Override
    public boolean onOptionsItemSelected(final MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {}

    @Override
    public void onPageSelected(int position) {
        Log.d("Slider Demo", "Page Changed: " + position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {}

}
