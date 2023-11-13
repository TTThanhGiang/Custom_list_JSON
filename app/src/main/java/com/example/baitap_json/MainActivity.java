package com.example.baitap_json;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lvUser;
    ArrayList<User> list;

    UserAdapter adapter;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvUser= findViewById(R.id.listuser);
        list = new ArrayList<>();

        adapter = new UserAdapter(this, R.layout.custom_listviewuser, list);

        lvUser.setAdapter(adapter);

        lvUser.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                User newuser = (User) list.get(position);
                Intent intent = new Intent(MainActivity.this, ChiTietActivity.class);
                intent.putExtra("select", newuser);
                startActivity(intent);

            }
        });


        new ReadJSON().execute("https://dummyjson.com/user");
    }
    private class ReadJSON extends AsyncTask<String, Void, String>{

        @Override
        protected String doInBackground(String... strings) {
            StringBuilder content = new StringBuilder();
            try{
                URL url = new URL(strings[0]);
                InputStreamReader inputStreamReader = new InputStreamReader(url.openConnection().getInputStream());
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

                String line = "";
                while ((line = bufferedReader.readLine())!= null){
                    content.append(line);
                }
                bufferedReader.close();
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return content.toString();
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            try {
                JSONObject object = new JSONObject(s);
                JSONArray array = object.getJSONArray("users");
                for (int i = 0; i< array.length();i++){
                    JSONObject objects =  array.getJSONObject(i);
                    String firstName = objects.getString("firstName");
                    String lastname = objects.getString("lastName");
                    String ngaysinh = objects.getString("birthDate");
                    String username = objects.getString("username");
                    String pass = objects.getString("password");
                    String phone = objects.getString("phone");
                    String img = objects.getString("image");
                    User user = new User(firstName,lastname,ngaysinh,username,pass,phone,img);
                    list.add(user);
                }
                adapter.notifyDataSetChanged();
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        }
    }
}