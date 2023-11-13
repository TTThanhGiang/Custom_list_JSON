package com.example.baitap_json;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class ChiTietActivity extends AppCompatActivity {
    TextView txtfirstname, txtlastname, txtbirthday, txtusername, txtpassword, txtphone;
    ImageView imgavartar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet);
        AnhXa();
        Intent intent = getIntent();
        User user = (User) intent.getSerializableExtra("select");
        Glide.with(this).load(user.getImg()).into(imgavartar);

        txtfirstname.setText(user.getFirstname());
        txtlastname.setText(user.getLastname());
        txtbirthday.setText(user.getBirthday());
        txtusername.setText(user.getUsername());
        txtpassword.setText(user.getPassword());
        txtphone.setText(user.getPhonenumber());

    }

    private void AnhXa() {
        txtfirstname = findViewById(R.id.txtfirstname);
        txtlastname = findViewById(R.id.txtlastname);
        txtbirthday = findViewById(R.id.txtbirthday);
        txtusername = findViewById(R.id.txtusername);
        txtpassword = findViewById(R.id.txtpassword);
        txtphone = findViewById(R.id.txtphonenumber);
        imgavartar = findViewById(R.id.avartar);
    }

}