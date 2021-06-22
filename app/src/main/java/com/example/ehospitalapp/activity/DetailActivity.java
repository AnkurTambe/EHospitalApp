package com.example.ehospitalapp.activity;

import android.os.Build;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ehospitalapp.R;
import com.example.ehospitalapp.fragment.D1Fragment;

public class DetailActivity extends AppCompatActivity {

    TextView textView;
    FrameLayout frameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        String type = getIntent().getStringExtra("type");

        textView = findViewById(R.id.title_txt_detail);
        frameLayout = findViewById(R.id.frame_detail);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.pink, this.getTheme()));
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.pink));
        }

        D1Fragment d1Fragment = new D1Fragment();

        Bundle b = new Bundle();
        b.putString("typeD1", type);
        d1Fragment.setArguments(b);

        getSupportFragmentManager().beginTransaction().replace(R.id.frame_detail,
                d1Fragment).commit();
        textView.setText(type);
    }
}