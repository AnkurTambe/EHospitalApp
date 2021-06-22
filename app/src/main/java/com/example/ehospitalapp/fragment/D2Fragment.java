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
import com.example.ehospitalapp.adapter.D2Adapter;
import com.example.ehospitalapp.model.D2Model;
import com.example.ehospitalapp.model.UserInfoModel;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.Objects;


public class D2Fragment extends Fragment {


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.fragment_d2, container, false);

        String mainT = getArguments().getString("mainT");
        String typeD23 = getArguments().getString("typeD23");

        ArrayList<D2Model> list = new ArrayList<D2Model>();
        RecyclerView recyclerView = root.findViewById(R.id.rv_d2);

// ****************************************************************************************
        if (mainT.equals("Patient")) {
            String url = "http://" + UserInfoModel.ip + "/EHospitalPhp/patient_d2.php?p_id=" + typeD23;


            RequestQueue rq = Volley.newRequestQueue(Objects.requireNonNull(getContext()));
            JsonArrayRequest jar = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
                @Override
                public void onResponse(JSONArray response) {

                    try {
                        list.add(
                                new D2Model(R.drawable.patient,
                                        response.getJSONObject(0).getString("p_name"),
                                        "ID.: " + response.getJSONObject(0).getString("p_id") + "\n" +
                                                "Admission Status: " + response.getJSONObject(0).getString("admission_status") + "\n" +
                                                "City: " + response.getJSONObject(0).getString("City") + "\n" +
                                                "State: " + response.getJSONObject(0).getString("State") + "\n" +
                                                "Age: " + response.getJSONObject(0).getInt("Age") + " yrs\n" +
                                                "No. of Tests Conducted: " + response.getJSONObject(0).getString("no_of_tests_conducted") + "\n" +
                                                "Ongoing Procedure: " + response.getJSONObject(0).getString("ongoing_medication") + "\n" +
                                                "Ph. No.: " + response.getJSONObject(0).getString("phone_no") + "\n" +
                                                "Gender: " + response.getJSONObject(0).getString("Gender") + "\n" +
                                                "Department: " + response.getJSONObject(0).getString("d_name") + "\n" +
                                                "Time of Admission: " + response.getJSONObject(0).getString("time_of_admission") + "\n" +
                                                "Type of Test: " + response.getJSONObject(0).getString("test_type") + "\n" +
                                                "Previous Operations: " + response.getJSONObject(0).getString("previous_operations") + "\n" +
                                                "Disability: " + response.getJSONObject(0).getString("Disability") + "\n" +
                                                "Previous Conditions: " + response.getJSONObject(0).getString("previous_conditions") + "\n" +
                                                "Previous Disease: " + response.getJSONObject(0).getString("previous_disease") + "\n" +
                                                "Time Span of Disease: " + response.getJSONObject(0).getString("time_span_of_disease") + "\n" +
                                                "Previous Medication: " + response.getJSONObject(0).getString("previous_medication")
                                )
                        );
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }


                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
                    recyclerView.setLayoutManager(linearLayoutManager);
                    recyclerView.setHasFixedSize(true);
                    D2Adapter dA = new D2Adapter(list, container.getContext());
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
        else if (mainT.equals("Admin")) {
            String url = "http://" + UserInfoModel.ip + "/EHospitalPhp/admin_d2.php?a_id=" + typeD23;


            RequestQueue rq = Volley.newRequestQueue(Objects.requireNonNull(getContext()));
            JsonArrayRequest jar = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
                @Override
                public void onResponse(JSONArray response) {

                    try {
                        list.add(
                                new D2Model(R.drawable.admin,
                                        response.getJSONObject(0).getString("name"),
                                        "ID.: " + response.getJSONObject(0).getString("a_id") + "\n" +
                                                "Ph. No.: " + response.getJSONObject(0).getString("phone_no") + "\n" +
                                                "Address: " + response.getJSONObject(0).getString("address") + "\n" +
                                                "Email ID.: " + response.getJSONObject(0).getString("email")
                                )
                        );
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }


                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
                    recyclerView.setLayoutManager(linearLayoutManager);
                    recyclerView.setHasFixedSize(true);
                    D2Adapter dA = new D2Adapter(list, container.getContext());
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
        else if (mainT.equals("Lab")) {
            String url = "http://" + UserInfoModel.ip + "/EHospitalPhp/lab_d2.php?lab_no=" + typeD23;


            RequestQueue rq = Volley.newRequestQueue(Objects.requireNonNull(getContext()));
            JsonArrayRequest jar = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
                @Override
                public void onResponse(JSONArray response) {
                    String s = "";
                    String a = "";
                    try {
                        for (int x = 0; x < response.length(); ++x) {
                            a = response.getJSONObject(x).getString("d_name");
                            s = s + " |" + a;
                        }
                        list.add(
                                new D2Model(R.drawable.lab,
                                        "Lab ID.: " + response.getJSONObject(0).getString("lab_no"),
                                        "No. of Equipments: " + response.getJSONObject(0).getString("no_of_equipments") + "\n" +
                                                "Test Type: " + response.getJSONObject(0).getString("type_of_test") + "\n" +
                                                "Department(s):" + s
                                )
                        );
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }


                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
                    recyclerView.setLayoutManager(linearLayoutManager);
                    recyclerView.setHasFixedSize(true);
                    D2Adapter dA = new D2Adapter(list, container.getContext());
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
        else if (mainT.equals("Doctor")) {
            String url = "http://" + UserInfoModel.ip + "/EHospitalPhp/doctor_d2.php?doc_id=" + typeD23;


            RequestQueue rq = Volley.newRequestQueue(Objects.requireNonNull(getContext()));
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


                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
                    recyclerView.setLayoutManager(linearLayoutManager);
                    recyclerView.setHasFixedSize(true);
                    D2Adapter dA = new D2Adapter(list, container.getContext());
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
        else if (mainT.equals("Jr. Doctor")) {
            String url = "http://" + UserInfoModel.ip + "/EHospitalPhp/jr_doc_d2.php?jun_id=" + typeD23;


            RequestQueue rq = Volley.newRequestQueue(Objects.requireNonNull(getContext()));
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


                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
                    recyclerView.setLayoutManager(linearLayoutManager);
                    recyclerView.setHasFixedSize(true);
                    D2Adapter dA = new D2Adapter(list, container.getContext());
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
        else if (mainT.equals("HR")) {
            String url = "http://" + UserInfoModel.ip + "/EHospitalPhp/hr_d2.php?HR_ID=" + typeD23;


            RequestQueue rq = Volley.newRequestQueue(Objects.requireNonNull(getContext()));
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


                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
                    recyclerView.setLayoutManager(linearLayoutManager);
                    recyclerView.setHasFixedSize(true);
                    D2Adapter dA = new D2Adapter(list, container.getContext());
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
        else if (mainT.equals("Maintena.")) {
            String url = "http://" + UserInfoModel.ip + "/EHospitalPhp/maintena_d2.php?main_id=" + typeD23;


            RequestQueue rq = Volley.newRequestQueue(Objects.requireNonNull(getContext()));
            JsonArrayRequest jar = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
                @Override
                public void onResponse(JSONArray response) {

                    try {
                        list.add(
                                new D2Model(R.drawable.maintenance,
                                        response.getJSONObject(0).getString("Main_name"),
                                        "ID.: " + response.getJSONObject(0).getString("main_id") + "\n" +
                                                "Salary: Rs. " + response.getJSONObject(0).getString("Salary") + "\n" +
                                                "Street: " + response.getJSONObject(0).getString("Street") + "\n" +
                                                "City: " + response.getJSONObject(0).getString("City") + "\n" +
                                                "Ph No.: " + response.getJSONObject(0).getString("phone_no")
                                )
                        );
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }


                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
                    recyclerView.setLayoutManager(linearLayoutManager);
                    recyclerView.setHasFixedSize(true);
                    D2Adapter dA = new D2Adapter(list, container.getContext());
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
        else if (mainT.equals("Department")) {
            String url = "http://" + UserInfoModel.ip + "/EHospitalPhp/department_d2.php?d_id=" + typeD23;


            RequestQueue rq = Volley.newRequestQueue(Objects.requireNonNull(getContext()));
            JsonArrayRequest jar = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
                @Override
                public void onResponse(JSONArray response) {

                    try {
                        list.add(
                                new D2Model(R.drawable.department,
                                        response.getJSONObject(0).getString("d_name"),
                                        "ID.: " + response.getJSONObject(0).getString("d_id") + "\n" +
                                                "No. of Rooms: " + response.getJSONObject(0).getString("no_of_rooms") + "\n" +
                                                "No. of Halls: " + response.getJSONObject(0).getString("no_of_halls") + "\n" +
                                                "No. of Consultancy Rooms: " + response.getJSONObject(0).getString("no_of_consultancy_rooms") + "\n" +
                                                "No of Beds: " + response.getJSONObject(0).getString("no_of_beds") + "\n" +
                                                "Beds Occupied: " + response.getJSONObject(0).getString("beds_occupied") + "\n" +
                                                "Patients Discharge Average: " + response.getJSONObject(0).getString("patient_discharge_average") + "\n" +
                                                "Patient Admission Rate Average: " + response.getJSONObject(0).getString("patient_admissionrate_average")
                                )
                        );
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }


                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
                    recyclerView.setLayoutManager(linearLayoutManager);
                    recyclerView.setHasFixedSize(true);
                    D2Adapter dA = new D2Adapter(list, container.getContext());
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
        else if (mainT.equals("Lab Tech.")) {
            String url = "http://" + UserInfoModel.ip + "/EHospitalPhp/lab_tech_d2.php?tech_id=" + typeD23;


            RequestQueue rq = Volley.newRequestQueue(Objects.requireNonNull(getContext()));
            JsonArrayRequest jar = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
                @Override
                public void onResponse(JSONArray response) {

                    try {
                        list.add(
                                new D2Model(R.drawable.lab_tech,
                                        response.getJSONObject(0).getString("tech_name"),
                                        "ID.: " + response.getJSONObject(0).getString("tech_id") + "\n" +
                                                "Salary: Rs. " + response.getJSONObject(0).getString("Salary") + "\n" +
                                                "Qualifications: " + response.getJSONObject(0).getString("Qualifications") + "\n" +
                                                "Ph. No.: " + response.getJSONObject(0).getString("phone_no") + "\n" +
                                                "Lab ID.: " + response.getJSONObject(0).getString("lab_no") + "\n" +
                                                "Test Type: " + response.getJSONObject(0).getString("type_of_test")
                                )
                        );
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }


                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
                    recyclerView.setLayoutManager(linearLayoutManager);
                    recyclerView.setHasFixedSize(true);
                    D2Adapter dA = new D2Adapter(list, container.getContext());
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
