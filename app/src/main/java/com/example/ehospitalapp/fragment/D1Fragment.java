package com.example.ehospitalapp.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.ehospitalapp.R;
import com.example.ehospitalapp.adapter.D1Adapter;
import com.example.ehospitalapp.model.D1Model;
import com.example.ehospitalapp.model.UserInfoModel;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.Objects;

public class D1Fragment extends Fragment {


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.fragment_d1, container, false);

        String typeD1 = getArguments().getString("typeD1");

        ArrayList<D1Model> list = new ArrayList<D1Model>();
        RecyclerView recyclerView = root.findViewById(R.id.rv_d1);

// ****************************************************************************************
        if (typeD1.equals("Admin")) {
            String url = "http://" + UserInfoModel.ip + "/EHospitalPhp/admin_d1.php";


            RequestQueue rq = Volley.newRequestQueue(Objects.requireNonNull(getContext()));
            JsonArrayRequest jar = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
                @Override
                public void onResponse(JSONArray response) {

                    for (int x = 0; x < response.length(); ++x) {
                        try {
                            list.add(
                                    new D1Model(response.getJSONObject(x).getString("name"),
                                            "Ph. No.: " + response.getJSONObject(x).getString("phone_no"),
                                            response.getJSONObject(x).getString("a_id"),
                                            R.drawable.admin
                                    )
                            );
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
                    recyclerView.setLayoutManager(linearLayoutManager);
                    recyclerView.setHasFixedSize(true);
                    D1Adapter dA = new D1Adapter(list, container.getContext(), typeD1);
                    recyclerView.setAdapter(dA);

                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(getContext(), "Error:" + error.getMessage() + " occurred", Toast.LENGTH_SHORT).show();
                }
            });

            rq.add(jar);
        }

// ****************************************************************************************
        else if (typeD1.equals("Department")) {
            String url = "http://" + UserInfoModel.ip + "/EHospitalPhp/department_d1.php";


            RequestQueue rq = Volley.newRequestQueue(Objects.requireNonNull(getContext()));
            JsonArrayRequest jar = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
                @Override
                public void onResponse(JSONArray response) {

                    for (int x = 0; x < response.length(); ++x) {
                        try {
                            list.add(
                                    new D1Model(response.getJSONObject(x).getString("d_name"),
                                            "No. of Rooms: " + response.getJSONObject(x).getString("no_of_rooms"),
                                            response.getJSONObject(x).getString("d_id"),
                                            R.drawable.department
                                    )
                            );
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
                    recyclerView.setLayoutManager(linearLayoutManager);
                    recyclerView.setHasFixedSize(true);
                    D1Adapter dA = new D1Adapter(list, container.getContext(), typeD1);
                    recyclerView.setAdapter(dA);

                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(getContext(), "Error:" + error.getMessage() + " occurred", Toast.LENGTH_SHORT).show();
                }
            });

            rq.add(jar);
        }

// ****************************************************************************************
        else if (typeD1.equals("Doctor")) {
            String url = "http://" + UserInfoModel.ip + "/EHospitalPhp/doctor_d1.php";


            RequestQueue rq = Volley.newRequestQueue(Objects.requireNonNull(getContext()));
            JsonArrayRequest jar = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
                @Override
                public void onResponse(JSONArray response) {

                    for (int x = 0; x < response.length(); ++x) {
                        try {
                            list.add(
                                    new D1Model(response.getJSONObject(x).getString("Doc_Name"),
                                            "Specialization: " + response.getJSONObject(x).getString("specialization"),
                                            response.getJSONObject(x).getString("Doc_ID"),
                                            R.drawable.doctor
                                    )
                            );
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
                    recyclerView.setLayoutManager(linearLayoutManager);
                    recyclerView.setHasFixedSize(true);
                    D1Adapter dA = new D1Adapter(list, container.getContext(), typeD1);
                    recyclerView.setAdapter(dA);

                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(getContext(), "Error:" + error.getMessage() + " occurred", Toast.LENGTH_SHORT).show();
                }
            });

            rq.add(jar);
        }


// ****************************************************************************************
        else if (typeD1.equals("HR")) {
            String url = "http://" + UserInfoModel.ip + "/EHospitalPhp/hr_d1.php";


            RequestQueue rq = Volley.newRequestQueue(Objects.requireNonNull(getContext()));
            JsonArrayRequest jar = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
                @Override
                public void onResponse(JSONArray response) {

                    for (int x = 0; x < response.length(); ++x) {
                        try {
                            list.add(
                                    new D1Model(response.getJSONObject(x).getString("HR_Name"),
                                            "Ph No.: " + response.getJSONObject(x).getString("phone_no"),
                                            response.getJSONObject(x).getString("HR_ID"),
                                            R.drawable.human_resource
                                    )
                            );
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
                    recyclerView.setLayoutManager(linearLayoutManager);
                    recyclerView.setHasFixedSize(true);
                    D1Adapter dA = new D1Adapter(list, container.getContext(), typeD1);
                    recyclerView.setAdapter(dA);

                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(getContext(), "Error:" + error.getMessage() + " occurred", Toast.LENGTH_SHORT).show();
                }
            });

            rq.add(jar);
        }


// ****************************************************************************************
        else if (typeD1.equals("Jr. Doctor")) {
            String url = "http://" + UserInfoModel.ip + "/EHospitalPhp/jr_doc_d1.php";


            RequestQueue rq = Volley.newRequestQueue(Objects.requireNonNull(getContext()));
            JsonArrayRequest jar = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
                @Override
                public void onResponse(JSONArray response) {

                    for (int x = 0; x < response.length(); ++x) {
                        try {
                            list.add(
                                    new D1Model(response.getJSONObject(x).getString("jun_Name"),
                                            "Qualifications: " + response.getJSONObject(x).getString("qualifications"),
                                            response.getJSONObject(x).getString("jun_ID"),
                                            R.drawable.jr_doctor
                                    )
                            );
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
                    recyclerView.setLayoutManager(linearLayoutManager);
                    recyclerView.setHasFixedSize(true);
                    D1Adapter dA = new D1Adapter(list, container.getContext(), typeD1);
                    recyclerView.setAdapter(dA);

                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(getContext(), "Error:" + error.getMessage() + " occurred", Toast.LENGTH_SHORT).show();
                }
            });

            rq.add(jar);
        }

// ****************************************************************************************
        else if (typeD1.equals("Lab Tech.")) {
            String url = "http://" + UserInfoModel.ip + "/EHospitalPhp/lab_tech_d1.php";


            RequestQueue rq = Volley.newRequestQueue(Objects.requireNonNull(getContext()));
            JsonArrayRequest jar = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
                @Override
                public void onResponse(JSONArray response) {

                    for (int x = 0; x < response.length(); ++x) {
                        try {
                            list.add(
                                    new D1Model(response.getJSONObject(x).getString("tech_Name"),
                                            "Qualifications: " + response.getJSONObject(x).getString("qualifications"),
                                            response.getJSONObject(x).getString("tech_ID"),
                                            R.drawable.lab_tech
                                    )
                            );
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
                    recyclerView.setLayoutManager(linearLayoutManager);
                    recyclerView.setHasFixedSize(true);
                    D1Adapter dA = new D1Adapter(list, container.getContext(), typeD1);
                    recyclerView.setAdapter(dA);

                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(getContext(), "Error:" + error.getMessage() + " occurred", Toast.LENGTH_SHORT).show();
                }
            });

            rq.add(jar);
        }

// ****************************************************************************************
        else if (typeD1.equals("Maintena.")) {
            String url = "http://" + UserInfoModel.ip + "/EHospitalPhp/maintena_d1.php";


            RequestQueue rq = Volley.newRequestQueue(Objects.requireNonNull(getContext()));
            JsonArrayRequest jar = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
                @Override
                public void onResponse(JSONArray response) {

                    for (int x = 0; x < response.length(); ++x) {
                        try {
                            list.add(
                                    new D1Model(response.getJSONObject(x).getString("Main_Name"),
                                            "Type: " + response.getJSONObject(x).getString("Main_Type"),
                                            response.getJSONObject(x).getString("Main_ID"),
                                            R.drawable.maintenance
                                    )
                            );
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
                    recyclerView.setLayoutManager(linearLayoutManager);
                    recyclerView.setHasFixedSize(true);
                    D1Adapter dA = new D1Adapter(list, container.getContext(), typeD1);
                    recyclerView.setAdapter(dA);

                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(getContext(), "Error:" + error.getMessage() + " occurred", Toast.LENGTH_SHORT).show();
                }
            });

            rq.add(jar);
        }

// ****************************************************************************************
        else if (typeD1.equals("Patient")) {
            String url = "http://" + UserInfoModel.ip + "/EHospitalPhp/patient_d1.php";


            RequestQueue rq = Volley.newRequestQueue(Objects.requireNonNull(getContext()));
            JsonArrayRequest jar = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
                @Override
                public void onResponse(JSONArray response) {

                    for (int x = 0; x < response.length(); ++x) {
                        try {
                            list.add(
                                    new D1Model(response.getJSONObject(x).getString("p_name"),
                                            "Ph. No.: " + response.getJSONObject(x).getString("phone_no"),
                                            response.getJSONObject(x).getString("p_id"),
                                            R.drawable.patient
                                    )
                            );
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
                    recyclerView.setLayoutManager(linearLayoutManager);
                    recyclerView.setHasFixedSize(true);
                    D1Adapter dA = new D1Adapter(list, container.getContext(), typeD1);
                    recyclerView.setAdapter(dA);

                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(getContext(), "Error:" + error.getMessage() + " occurred", Toast.LENGTH_SHORT).show();
                }
            });

            rq.add(jar);
        }


// ****************************************************************************************
        else if (typeD1.equals("Lab")) {
            String url = "http://" + UserInfoModel.ip + "/EHospitalPhp/lab_d1.php";


            RequestQueue rq = Volley.newRequestQueue(Objects.requireNonNull(getContext()));
            JsonArrayRequest jar = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
                @Override
                public void onResponse(JSONArray response) {

                    for (int x = 0; x < response.length(); ++x) {
                        try {
                            list.add(
                                    new D1Model(
                                            response.getJSONObject(x).getString("type_of_test") + " Lab",
                                            "No. of Equipments: " + response.getJSONObject(x).getString("no_of_equipments"),
                                            response.getJSONObject(x).getString("lab_no"),
                                            R.drawable.lab
                                    )
                            );
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
                    recyclerView.setLayoutManager(linearLayoutManager);
                    recyclerView.setHasFixedSize(true);
                    D1Adapter dA = new D1Adapter(list, container.getContext(), typeD1);
                    recyclerView.setAdapter(dA);

                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(getContext(), "Error:" + error.getMessage() + " occurred", Toast.LENGTH_SHORT).show();
                }
            });

            rq.add(jar);
        }
        return root;
    }
}
