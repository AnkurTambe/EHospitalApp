package com.example.ehospitalapp.activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.ehospitalapp.R;
import com.example.ehospitalapp.fragment.DashboardFragment;
import com.example.ehospitalapp.model.UserInfoModel;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.Objects;

public class HrActivity extends AppCompatActivity {

    TextView textView1;
    TextView textView2;
    TextView textView3;
    ImageView imageView;
    FrameLayout frameLayout;
    String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all);

        textView1 = findViewById(R.id.title_txt_all);
        textView2 = findViewById(R.id.subtitle_text_all);
        textView3 = findViewById(R.id.hi_real_txt_all);
        imageView = findViewById(R.id.profile_icon);
        frameLayout = findViewById(R.id.frame_all);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.pink, this.getTheme()));
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.pink));
        }

        String url = "http://" + UserInfoModel.ip + "/EHospitalPhp/hi_hr.php?phone_no=" + UserInfoModel.phone_no;

        RequestQueue rq = Volley.newRequestQueue(Objects.requireNonNull(getApplicationContext()));
        JsonArrayRequest jar = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                try {
                    id = response.getJSONObject(0).getString("HR_ID");

                    textView3.setText(response.getJSONObject(0).getString("HR_Name"));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), "Error:" + error.getMessage() + " Hi Text Failed", Toast.LENGTH_SHORT).show();
            }
        });

        rq.add(jar);

        textView1.setText("DashBoard");
        textView2.setText("Select one to get more Info.:");
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_all,
                new DashboardFragment()).commit();

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), ProfileActivity.class);
                i.putExtra("id", id);
                startActivity(i);
            }
        });

    }
}