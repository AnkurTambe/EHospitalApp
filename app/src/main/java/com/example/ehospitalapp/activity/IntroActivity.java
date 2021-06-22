package com.example.ehospitalapp.activity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.airbnb.lottie.LottieAnimationView;
import com.example.ehospitalapp.R;
import com.example.ehospitalapp.fragment.OB1Fragment;
import com.example.ehospitalapp.fragment.OB2Fragment;
import com.example.ehospitalapp.fragment.OB3Fragment;
import com.example.ehospitalapp.model.UserInfoModel;

import java.util.Objects;

public class IntroActivity extends AppCompatActivity {

    ImageView logo, splashBg;
    LottieAnimationView lottieAnimationView;

    private EditText ip;

    private static final int NUM_PAGES = 3;
    private ViewPager viewPager;
    private ScreenSlidePagerAdapter pagerAdapter;
    Animation anim;

    private static int SPLASH_TIME_OUT = 5000;
    SharedPreferences sharedPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.pink, this.getTheme()));
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.pink));
        }

        logo = findViewById(R.id.logo);
        splashBg = findViewById(R.id.splash_bg);
        lottieAnimationView = findViewById(R.id.lottie_splash);

        splashBg.animate().translationY(-3200).setDuration(1000).setStartDelay(4000);
        logo.animate().translationY(2800).setDuration(1000).setStartDelay(4000);
        lottieAnimationView.animate().translationY(2800).setDuration(1000).setStartDelay(4000);

        SharedPreferences ipadd = Objects.requireNonNull(getSharedPreferences("ip", Context.MODE_PRIVATE));

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        LayoutInflater inflater = getLayoutInflater();
        View view = inflater.inflate(R.layout.layout_dialog, null);

        ip = view.findViewById(R.id.et_ip);
        ip.setText(ipadd.getString("ipc", " "));

        builder.setView(view)
                .setCancelable(false)
                .setTitle("IP Address")
                .setMessage("Ensure that this device and the PC(hosting WAMP server) are connected to the same WIFI network.\nEnter the IPv4 Address of the corresponding WLAN.\n ")
                .setNegativeButton("Exit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                        System.exit(0);
                    }
                })
                .setPositiveButton("Proceed", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if (ip.getText().toString().isEmpty()) {
                            Toast.makeText(
                                    getApplicationContext(),
                                    "Give proper IP, else previous entered IP will be considered.",
                                    Toast.LENGTH_LONG
                            ).show();
                        } else {
                            ipadd.edit().putString("ipc", ip.getText().toString()).apply();
                            UserInfoModel.ip = ipadd.getString("ipc", " ");
                        }
                        sharedPref = getSharedPreferences("SharedPref", MODE_PRIVATE);
                        boolean isFirstTime = sharedPref.getBoolean("firstTime", true);
                        if (isFirstTime) {
                            SharedPreferences.Editor editor = sharedPref.edit();
                            editor.putBoolean("firstTime", false);
                            editor.commit();
                            viewPager = findViewById(R.id.pager);
                            pagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());
                            viewPager.setAdapter(pagerAdapter);

                            anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.ob_anim);
                            viewPager.startAnimation(anim);
                        } else {
                            Intent intent = new Intent(IntroActivity.this, LoginActivity.class);
                            startActivity(intent);
                            finish();
                        }

                        Toast.makeText(getApplicationContext(), UserInfoModel.ip, Toast.LENGTH_SHORT).show();

                    }
                });

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                builder.create().show();
            }
        }, SPLASH_TIME_OUT);


    }

    private class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {

        public ScreenSlidePagerAdapter(@NonNull FragmentManager fm) {
            super(fm);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    OB1Fragment tab1 = new OB1Fragment();
                    return tab1;
                case 1:
                    OB2Fragment tab2 = new OB2Fragment();
                    return tab2;
                case 2:
                    OB3Fragment tab3 = new OB3Fragment();
                    return tab3;
            }
            return null;
        }

        @Override
        public int getCount() {
            return NUM_PAGES;
        }
    }
}