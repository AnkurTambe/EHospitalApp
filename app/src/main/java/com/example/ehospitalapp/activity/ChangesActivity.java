package com.example.ehospitalapp.activity;

import android.os.Build;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.ehospitalapp.R;
import com.example.ehospitalapp.adapter.ChangesAdapter;
import com.example.ehospitalapp.model.D1Model;
import com.example.ehospitalapp.model.UserInfoModel;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.Objects;

public class ChangesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_changes);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.pink, this.getTheme()));
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.pink));
        }

        ArrayList<D1Model> list = new ArrayList<D1Model>();
        RecyclerView recyclerView = findViewById(R.id.rv_cha);

        String url = "http://" + UserInfoModel.ip + "/EHospitalPhp/admin_pro.php";


        RequestQueue rq = Volley.newRequestQueue(Objects.requireNonNull(getApplication()));
        JsonArrayRequest jar = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                for (int x = 0; x < response.length(); ++x) {
                    try {
                        list.add(
                                new D1Model(response.getJSONObject(x).getString("name"),
                                        "Ph. No.: " + response.getJSONObject(x).getString("phone_no"),
                                        response.getJSONObject(x).getString("email"),
                                        R.drawable.admin
                                )
                        );
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
                recyclerView.setLayoutManager(linearLayoutManager);
                recyclerView.setHasFixedSize(true);
                ChangesAdapter dA = new ChangesAdapter(list, getApplicationContext());
                recyclerView.setAdapter(dA);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), "Error:" + error.getMessage() + " occurred", Toast.LENGTH_SHORT).show();
            }
        });

        rq.add(jar);

    }
}