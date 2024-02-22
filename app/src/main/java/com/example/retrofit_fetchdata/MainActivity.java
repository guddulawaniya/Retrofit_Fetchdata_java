package com.example.retrofit_fetchdata;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    mydatabaseHalper dbHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        dbHelper  = new mydatabaseHalper(this);

        dbHelper.insertdata("guddulawaniya","guddulawaniya","123456789");


        Cursor cursor = dbHelper.getdata();
        String data = null;
        if (cursor.moveToNext())
        {
           String name = cursor.getString(1);
           String email = cursor.getString(2);
           String password = cursor.getString(3);

           showdata(name,email,password);


        }

        dbHelper.close();
        fetchapidata();

    }
void showdata(String name ,String email,String password)
{
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

            // Set the dialog title and message
            builder.setTitle("User data")
                    .setMessage("name : "+name+"\n email :"+email+"\n password : "+password);

            // Set positive button and its action
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    // Perform some action when OK button is clicked
                    dialog.dismiss();
                }
            });

            // Set negative button and its action (optional)
            builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    // Perform some action when Cancel button is clicked
                    dialog.cancel();
                }
            });

            // Create and show the AlertDialog
            AlertDialog alertDialog = builder.create();
            alertDialog.show();
        }
    void fetchapidata() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Methods methods = retrofit.create(Methods.class);
        Call<List<Mymodule>> call = methods.getdata();

        call.enqueue(new Callback<List<Mymodule>>() {
            @Override
            public void onResponse(Call<List<Mymodule>> call, Response<List<Mymodule>> response) {
                if (response.isSuccessful()) {
                    myadapter myadapter = new myadapter(response.body());
                    recyclerView.setAdapter(myadapter);
                }

            }
            @Override
            public void onFailure(Call<List<Mymodule>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "something want wrong ", Toast.LENGTH_SHORT).show();
            }
        });
    }
}