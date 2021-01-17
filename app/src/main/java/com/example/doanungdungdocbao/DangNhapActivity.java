package com.example.doanungdungdocbao;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.doanungdungdocbao.Data.SaveState;

public class DangNhapActivity extends AppCompatActivity {
    private EditText txtEmail, txtPass;
    private Button btnDangNhap;
    private static String URL_DANGNHAP = "http://10.0.2.2:8000/api/dang-nhap";
    SaveState saveState;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.dangnhap, container, false);
        return root;
    }
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dangnhap);
        txtEmail = findViewById(R.id.editTextTextPersonName);
        txtPass = findViewById(R.id.editTextTextPassword);
        btnDangNhap = findViewById(R.id.btn_dangnhap2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_dangnhap);
        setSupportActionBar(toolbar);
        ; //sudung toolbar nhu actionbar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //set nut back cho toolbar
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        someMethodThatUsesActivity(this);
    }
    public void someMethodThatUsesActivity(Activity myActivityReference){
        myActivityReference.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }
}
