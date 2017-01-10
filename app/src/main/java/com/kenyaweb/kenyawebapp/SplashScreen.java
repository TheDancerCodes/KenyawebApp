package com.kenyaweb.kenyawebapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import com.crashlytics.android.Crashlytics;
import io.fabric.sdk.android.Fabric;

/**
 * Created by nabwera_taracha on 4/27/16.
 */
public class SplashScreen extends Activity {

    private int displayTime = 4000;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);

        //Added Crashlytics
        Fabric.with(this, new Crashlytics());

        setContentView(R.layout.splash_screen);

        Thread splashThread = new Thread(){
            int wait = 0;

            @Override
            public void run(){
                try{
                    super.run();

                    while(wait<displayTime){
                        sleep(100);
                        wait += 100;
                    }
                }catch(Exception e){}
                finally{
                    //Intent intent = new Intent(splashActivity.this,toutMain.class);
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                    finish();


                }
            }


        };
        splashThread.start();
    }

}
