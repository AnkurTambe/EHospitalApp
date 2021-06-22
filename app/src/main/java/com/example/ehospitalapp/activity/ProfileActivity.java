package com.example.ehospitalapp.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
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
import com.example.ehospitalapp.adapter.D2Adapter;
import com.example.ehospitalapp.model.D2Model;
import com.example.ehospitalapp.model.UserInfoModel;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.Objects;

public class ProfileActivity extends AppCompatActivity {
    TextView textView1;
    Button logout;
    Button changes;
    Button cIp;
    RecyclerView recyclerView;
    SharedPreferences token;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        token = getSharedPreferences("LOGIN", MODE_PRIVATE);


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.pink, this.getTheme()));
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.pink));
        }

        textView1 = findViewById(R.id.pro_real_sign_txt);
        recyclerView = findViewById(R.id.rv_pro);
        logout = findViewById(R.id.btn_logout_pro);
        changes = findViewById(R.id.btn_changes_pro);
        cIp = findViewById(R.id.btn_cip);

        String mainT = UserInfoModel.loginDet;
        String typeD23 = getIntent().getStringExtra("id");

        ArrayList<D2Model> list = new ArrayList<D2Model>();

        textView1.setText(UserInfoModel.loginDet);

// ****************************************************************************************
        if (mainT.equals("Admin")) {

            changes.setText("Check 'Changes' Requests(You'll be redirected to your Gmail Inbox.)");
            String url = "http://" + UserInfoModel.ip + "/EHospitalPhp/admin_d2.php?a_id=" + typeD23;


            RequestQueue rq = Volley.newRequestQueue(Objects.requireNonNull(getApplicationContext()));
            JsonArrayRequest jar = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
                @Override
                public void onResponse(JSONArray response) {

                    try {
                        list.add(
                                new D2Model(R.drawable.admin,
                                        response.getJSONObject(0).getString("name"),
                                        "ID.: " + response.getJSONObject(0).getString("a_id") + "\n" +
                                                "Ph. No.: " + response.getJSONObject(0).getString("phone_no") + "\n" +
                                                "Address: " + response.getJSONObject(0).getString("address")
                                )
                        );
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }


                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
                    recyclerView.setLayoutManager(linearLayoutManager);
                    recyclerView.setHasFixedSize(true);
                    D2Adapter dA = new D2Adapter(list, getApplicationContext());
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

// ****************************************************************************************
        else if (mainT.equals("Doctor")) {
            String url = "http://" + UserInfoModel.ip + "/EHospitalPhp/doctor_d2.php?doc_id=" + typeD23;


            RequestQueue rq = Volley.newRequestQueue(Objects.requireNonNull(getApplicationContext()));
            JsonArrayRequest jar = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
                @Override
                public void onResponse(JSONArray response) {

                    try {
                        list.add(
                                new D2Model(R.drawable.doctor,
                                        response.getJSONObject(0).getString("Doc_Name"),
                                        "ID.: " + response.getJSONObject(0).getString("Doc_ID") + "\n" +
                                                "Salary: Rs. " + response.getJSONObject(0).getString("Salary") + "\n" +
                                                "Age: " + response.getJSONObject(0).getString("Age") + " yrs\n" +
                                                "Degree Level: " + response.getJSONObject(0).getString("Degree_level") + "\n" +
                                                "Yrs. of Experience: " + response.getJSONObject(0).getString("years_exp") + " yrs\n" +
                                                "Specialization: " + response.getJSONObject(0).getString("Specialization") + "\n" +
                                                "Night Shift Starts: " + response.getJSONObject(0).getString("night_shift_start") + "\n" +
                                                "Night Shift Ends: " + response.getJSONObject(0).getString("Night_shift_end") + "\n" +
                                                "Patients Attended: " + response.getJSONObject(0).getString("patients_attended") + "\n" +
                                                "Ph. No.: " + response.getJSONObject(0).getString("phone_no") + "\n" +
                                                "Department: " + response.getJSONObject(0).getString("d_name") + "\n" +
                                                "Junior Assigned: " + response.getJSONObject(0).getString("jun_name")
                                )
                        );
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }


                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
                    recyclerView.setLayoutManager(linearLayoutManager);
                    recyclerView.setHasFixedSize(true);
                    D2Adapter dA = new D2Adapter(list, getApplicationContext());
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


// ****************************************************************************************
        else if (mainT.equals("Jr. Doctor")) {
            String url = "http://" + UserInfoModel.ip + "/EHospitalPhp/jr_doc_d2.php?jun_id=" + typeD23;


            RequestQueue rq = Volley.newRequestQueue(Objects.requireNonNull(getApplicationContext()));
            JsonArrayRequest jar = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
                @Override
                public void onResponse(JSONArray response) {

                    try {
                        list.add(
                                new D2Model(R.drawable.jr_doctor,
                                        response.getJSONObject(0).getString("jun_Name"),
                                        "ID.: " + response.getJSONObject(0).getString("jun_ID") + "\n" +
                                                "Salary: Rs. " + response.getJSONObject(0).getString("Salary") + "\n" +
                                                "Qualifications: " + response.getJSONObject(0).getString("Qualifications") + "\n" +
                                                "Yrs. of Experience: " + response.getJSONObject(0).getString("Years_exp") + " yrs\n" +
                                                "Night Shift Start: " + response.getJSONObject(0).getString("Night_shift_start") + "\n" +
                                                "Night Shift End: " + response.getJSONObject(0).getString("night_shift_end") + "\n" +
                                                "Ph. No.: " + response.getJSONObject(0).getString("phone_no") + "\n" +
                                                "Department: " + response.getJSONObject(0).getString("d_name") + "\n" +
                                                "Senior Assigned: " + response.getJSONObject(0).getString("doc_name")
                                )
                        );
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }


                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
                    recyclerView.setLayoutManager(linearLayoutManager);
                    recyclerView.setHasFixedSize(true);
                    D2Adapter dA = new D2Adapter(list, getApplicationContext());
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

// ****************************************************************************************
        else if (mainT.equals("Human Resources")) {
            String url = "http://" + UserInfoModel.ip + "/EHospitalPhp/hr_d2.php?HR_ID=" + typeD23;


            RequestQueue rq = Volley.newRequestQueue(Objects.requireNonNull(getApplicationContext()));
            JsonArrayRequest jar = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
                @Override
                public void onResponse(JSONArray response) {

                    try {
                        list.add(
                                new D2Model(R.drawable.human_resource,
                                        response.getJSONObject(0).getString("HR_Name"),
                                        "ID.: " + response.getJSONObject(0).getString("HR_ID") + "\n" +
                                                "Salary: Rs. " + response.getJSONObject(0).getString("Salary") + "\n" +
                                                "Timings: " + response.getJSONObject(0).getString("Timing") + "\n" +
                                                "Ph. No.: " + response.getJSONObject(0).getString("phone_no")
                                )
                        );
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }


                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
                    recyclerView.setLayoutManager(linearLayoutManager);
                    recyclerView.setHasFixedSize(true);
                    D2Adapter dA = new D2Adapter(list, getApplicationContext());
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

        changes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mainT.equals("Admin")) {
//                    Uri uri = Uri.parse("https://mail.google.com/mail/u/0/#inbox");
//                    Intent i = new Intent(Intent.ACTION_VIEW, uri);
//                    startActivity(i);

                    PackageManager manager = getPackageManager();
                    Intent i = manager.getLaunchIntentForPackage("com.google.android.gm");
                    i.addCategory(Intent.CATEGORY_LAUNCHER);
                    startActivity(i);
                } else {
                    Intent i = new Intent(getApplicationContext(), ChangesActivity.class);
                    startActivity(i);
                }
            }
        });

        cIp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ExampleDialog exampleDialog = new ExampleDialog();
                exampleDialog.setCancelable(false);
                exampleDialog.show(getSupportFragmentManager(), "example dialog");
            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder = new AlertDialog.Builder(ProfileActivity.this);
                builder.setCancelable(false);
                builder.setTitle("Alert");
                builder.setMessage("Do you want to Log Out?");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        SharedPreferences.Editor editor = token.edit();
                        editor.clear();
                        editor.commit();
                        Toast.makeText(getApplicationContext(), "Logged Out!", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(getApplicationContext(), LoginActivity.class);
                        startActivity(i);
                        finish();
                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
                builder.create().show();


            }
        });

    }
}