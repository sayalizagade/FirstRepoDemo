package com.sourcey.materiallogindemo;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private String url="http://bitcode.info/ws_ios_assignment/ws_dog_info.php";
    private LinearLayoutManager linearLayoutManager;
    private DividerItemDecoration dividerItemDecoration;
    private List<Dog> DogList;
    private RecyclerView rlist;
    private RecyclerView.Adapter adapter;
    private Gson gson;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        getdata();


    }
    public void init(){

        rlist=findViewById(R.id.main_list);
        DogList=new ArrayList<>();
        adapter=new DogAdapter(getApplicationContext(),DogList);

        linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        dividerItemDecoration = new DividerItemDecoration(rlist.getContext(), linearLayoutManager.getOrientation());

        rlist.setHasFixedSize(true);
        rlist.setLayoutManager(linearLayoutManager);
        rlist.addItemDecoration(dividerItemDecoration);
        rlist.setAdapter(adapter);


    }

    public void getdata(){

        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading");
        progressDialog.show();

        final JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int i = 0; i < response.length(); i++) {
                    Log.e("responce is", String.valueOf(response));
                    try {
                        JSONObject jsonObject = response.getJSONObject(i);
                        Dog dog = new Gson().fromJson(jsonObject.toString(),Dog.class);




//                        Dog dog = new Dog();
//                        dog.setBreed(jsonObject.getString("breed"));
//                        dog.setColors(jsonObject.getString("Colors"));
//                        dog.setDogInfo(jsonObject.getString("info"));
//                        dog.setLifeSpan(jsonObject.getString("Life span"));
                        DogList.add(dog);
                    } catch (JSONException e) {
                        e.printStackTrace();
                        progressDialog.dismiss();
                    }
                }
                adapter.notifyDataSetChanged();
                progressDialog.dismiss();
            }

        },new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("Volley", error.toString());
                progressDialog.dismiss();
            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(jsonArrayRequest);
    }
}
