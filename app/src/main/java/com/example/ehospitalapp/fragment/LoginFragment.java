package com.example.ehospitalapp.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.ehospitalapp.R;
import com.example.ehospitalapp.activity.AdminActivity;
import com.example.ehospitalapp.activity.DocActivity;
import com.example.ehospitalapp.activity.ExampleDialog;
import com.example.ehospitalapp.activity.HrActivity;
import com.example.ehospitalapp.activity.JrDocActivity;
import com.example.ehospitalapp.model.UserInfoModel;

import java.util.Objects;

public class LoginFragment extends Fragment implements View.OnClickListener {

    EditText phone;
    EditText pass;
    Button btnLogin;
    Button btnCi;
    Spinner spinner;

    SharedPreferences token;

    float v = 0;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.fragment_login, container, false);

        token = getContext().getSharedPreferences("LOGIN", Context.MODE_PRIVATE);

        if (token.getString("phno", " ") != " ") {

            if (token.getString("lgdet", " ").equals("Admin")) {
                Intent i = new Intent(getContext(), AdminActivity.class);
                startActivity(i);
                getActivity().finish();
            } else if (token.getString("lgdet", " ").equals("Doctor")) {
                Intent i = new Intent(getContext(), DocActivity.class);
                startActivity(i);
                getActivity().finish();
            } else if (token.getString("lgdet", " ").equals("Jr. Doctor")) {
                Intent i = new Intent(getContext(), JrDocActivity.class);
                startActivity(i);
                getActivity().finish();
            } else if (token.getString("lgdet", " ").equals("Human Resources")) {
                Intent i = new Intent(getContext(), HrActivity.class);
                startActivity(i);
                getActivity().finish();
            }
        }

        phone = root.findViewById(R.id.phone);
        pass = root.findViewById(R.id.pass);
        btnLogin = root.findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(this);
        spinner = root.findViewById(R.id.spinner_list);


        phone.setTranslationX(800);
        pass.setTranslationX(800);
        btnLogin.setTranslationX(800);
        spinner.setTranslationX(800);

        phone.setAlpha(v);
        pass.setAlpha(v);
        btnLogin.setAlpha(v);
        spinner.setAlpha(v);

        spinner.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(300).start();
        phone.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(500).start();
        pass.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(700).start();
        btnLogin.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(900).start();


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(container.getContext(), android.R.layout.simple_spinner_dropdown_item) {

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {

                View v = super.getView(position, convertView, parent);
                if (position == getCount()) {
                    ((TextView) v.findViewById(android.R.id.text1)).setText("");
                    ((TextView) v.findViewById(android.R.id.text1)).setHint(getItem(getCount())); //"Hint to be displayed"
                }
                return v;
            }

            @Override
            public int getCount() {
                return super.getCount() - 1; // you dont display last item. It is used as hint.
            }
        };

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter.add("Admin");
        adapter.add("Doctor");
        adapter.add("Jr. Doctor");
        adapter.add("Human Resources");
        adapter.add("Select Your Login:"); //This is the text that will be displayed as hint.


        spinner.setAdapter(adapter);
        spinner.setSelection(adapter.getCount()); //set the hint the default selection so it appears on launch.
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                // TODO Auto-generated method stub
            }
        });

        btnCi = root.findViewById(R.id.btn_ci);

        btnCi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog();
            }
        });
        return root;
    }


    @Override
    public void onClick(View v) {
        if (phone.getText().toString().isEmpty() || pass.getText().toString().isEmpty() || spinner.getSelectedItem().toString().equals("Select Your Login:")
        ) {
            Toast.makeText(getContext(), "Give Proper Info.", Toast.LENGTH_SHORT).show();
        } else {
// ****************************************************************************************
            if (spinner.getSelectedItem().toString().equals("Admin")) {
                String url = "http://" + UserInfoModel.ip + "/EHospitalPhp/loginAdmin.php?phone_no=" + phone.getText().toString() + "&pass=" + pass.getText().toString();

                RequestQueue rq = Volley.newRequestQueue(Objects.requireNonNull(getContext()));

                StringRequest sr = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if (response.equals("0")) {
                            Toast.makeText(getContext(), "Invalid Credentials", Toast.LENGTH_SHORT).show();
                        } else {
                            UserInfoModel.phone_no = phone.getText().toString();
                            UserInfoModel.loginDet = spinner.getSelectedItem().toString();
                            Toast.makeText(getContext(), "Logged In as Admin!", Toast.LENGTH_SHORT).show();

                            Intent i = new Intent(getContext(), AdminActivity.class);


                            SharedPreferences.Editor editor = token.edit();
                            editor.putString("phno", UserInfoModel.phone_no);
                            editor.putString("lgdet", UserInfoModel.loginDet);
                            editor.apply();

                            startActivity(i);
                            getActivity().finish();
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getContext(), "Error:" + error.getMessage() + " Log In Failed", Toast.LENGTH_SHORT).show();
                    }
                });

                rq.add(sr);
            }
// ****************************************************************************************
            else if (spinner.getSelectedItem().toString().equals("Doctor")) {
                String url = "http://" + UserInfoModel.ip + "/EHospitalPhp/loginDoctor.php?phone_no=" + phone.getText().toString() + "&pass=" + pass.getText().toString();

                RequestQueue rq = Volley.newRequestQueue(getContext());

                StringRequest sr = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if (response.equals("0")) {
                            Toast.makeText(getContext(), "Invalid Credentials", Toast.LENGTH_SHORT).show();
                        } else {
                            UserInfoModel.phone_no = phone.getText().toString();
                            UserInfoModel.loginDet = spinner.getSelectedItem().toString();
                            Toast.makeText(getContext(), "Logged In as Doc!", Toast.LENGTH_SHORT).show();

                            Intent i = new Intent(getContext(), DocActivity.class);


                            SharedPreferences.Editor editor = token.edit();
                            editor.putString("phno", UserInfoModel.phone_no);
                            editor.putString("lgdet", UserInfoModel.loginDet);
                            editor.apply();
                            startActivity(i);
                            getActivity().finish();
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getContext(), "Error:" + error.getMessage() + " Log In Failed", Toast.LENGTH_SHORT).show();
                    }
                });

                rq.add(sr);
            }
// ****************************************************************************************
            else if (spinner.getSelectedItem().toString().equals("Jr. Doctor")) {
                String url = "http://" + UserInfoModel.ip + "/EHospitalPhp/loginJrDoctor.php?phone_no=" + phone.getText().toString() + "&pass=" + pass.getText().toString();

                RequestQueue rq = Volley.newRequestQueue(getContext());

                StringRequest sr = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if (response.equals("0")) {
                            Toast.makeText(getContext(), "Invalid Credentials", Toast.LENGTH_SHORT).show();
                        } else {
                            UserInfoModel.phone_no = phone.getText().toString();
                            UserInfoModel.loginDet = spinner.getSelectedItem().toString();
                            Toast.makeText(getContext(), "Logged In as Jr. Doc!", Toast.LENGTH_SHORT).show();

                            Intent i = new Intent(getContext(), JrDocActivity.class);

                            SharedPreferences.Editor editor = token.edit();
                            editor.putString("phno", UserInfoModel.phone_no);
                            editor.putString("lgdet", UserInfoModel.loginDet);
                            editor.apply();
                            startActivity(i);
                            getActivity().finish();

                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getContext(), "Error:" + error.getMessage() + " Log In Failed", Toast.LENGTH_SHORT).show();
                    }
                });

                rq.add(sr);
            }
// ****************************************************************************************
            else if (spinner.getSelectedItem().toString().equals("Human Resources")) {
                String url = "http://" + UserInfoModel.ip + "/EHospitalPhp/loginHR.php?phone_no=" + phone.getText().toString() + "&pass=" + pass.getText().toString();

                RequestQueue rq = Volley.newRequestQueue(getContext());

                StringRequest sr = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if (response.equals("0")) {
                            Toast.makeText(getContext(), "Invalid Credentials", Toast.LENGTH_SHORT).show();
                        } else {
                            UserInfoModel.phone_no = phone.getText().toString();
                            UserInfoModel.loginDet = spinner.getSelectedItem().toString();
                            Toast.makeText(getContext(), "Logged In as HR!", Toast.LENGTH_SHORT).show();

                            Intent i = new Intent(getContext(), HrActivity.class);

                            SharedPreferences.Editor editor = token.edit();
                            editor.putString("phno", UserInfoModel.phone_no);
                            editor.putString("lgdet", UserInfoModel.loginDet);
                            editor.apply();
                            startActivity(i);
                            getActivity().finish();


                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getContext(), "Error:" + error.getMessage() + " Log In Failed", Toast.LENGTH_SHORT).show();
                    }
                });

                rq.add(sr);
            }
        }
    }

    private void openDialog() {
        ExampleDialog exampleDialog = new ExampleDialog();
        exampleDialog.setCancelable(false);
        exampleDialog.show(getFragmentManager(), "example dialog");
    }

}