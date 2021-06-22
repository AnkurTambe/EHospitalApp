package com.example.ehospitalapp.activity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDialogFragment;

import com.example.ehospitalapp.R;
import com.example.ehospitalapp.model.UserInfoModel;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class ExampleDialog extends AppCompatDialogFragment {

    private EditText ip;

    @NonNull
    @NotNull
    @Override
    public Dialog onCreateDialog(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {

        SharedPreferences ipadd = Objects.requireNonNull(getContext()).getSharedPreferences("ip", Context.MODE_PRIVATE);

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.layout_dialog, null);

        ip = view.findViewById(R.id.et_ip);
        ip.setText(ipadd.getString("ipc", " "));

        builder.setView(view)
                .setCancelable(false)
                .setTitle("IP Address")
                .setMessage("Ensure that this device and the PC(hosting WAMP server) are connected to the same WIFI network.\nEnter the IPv4 Address of the corresponding WLAN.\n ")
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getActivity(), UserInfoModel.ip, Toast.LENGTH_SHORT).show();
                    }
                })
                .setPositiveButton("Proceed", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if (ip.getText().toString().isEmpty()) {
                            Toast.makeText(
                                    getActivity(),
                                    "Give proper IP, else previous entered IP will be considered.",
                                    Toast.LENGTH_LONG
                            ).show();
                        } else {
                            ipadd.edit().putString("ipc", ip.getText().toString()).apply();
                            UserInfoModel.ip = ipadd.getString("ipc", " ");

                        }
                        Toast.makeText(getActivity(), UserInfoModel.ip, Toast.LENGTH_SHORT).show();

                    }
                });

        return builder.create();
    }
}
