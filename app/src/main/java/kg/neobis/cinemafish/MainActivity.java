package kg.neobis.cinemafish;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

import kg.neobis.cinemafish.model.JSONResponse;
import kg.neobis.cinemafish.model.Unmain;
import kg.neobis.cinemafish.ui.RecyclerViewAdapter;
import kg.neobis.cinemafish.util.Api;
import kg.neobis.cinemafish.util.Network;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements RecyclerViewAdapter.OnItemClickListener {

    private Network network = new Network();
    private final static String BASE_URL = "https://kinoafisha.ua";

    public TextView rvItemText;

    private ArrayList<Unmain> unmainArrayList;
    private ArrayList<String> mKinoteatrNames = new ArrayList<>();
    private ArrayList<String> mKinoteatrImageUrls = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        initImagesAndTextsMenu();

    }


    private void initImagesAndTextsMenu() {
        Log.d("Response", "initImagesAndTexts");
        network.getApiClass().getJSON().enqueue(new Callback<JSONResponse>() {
            @Override
            public void onResponse(Call<JSONResponse> call, Response<JSONResponse> response) {
                unmainArrayList = response.body().getResult().getUnmain();
                Log.d("unmainArraylIst",""+ unmainArrayList.get(45).getImage());
                for(Unmain kinoteatr : unmainArrayList){
                    mKinoteatrNames.add(kinoteatr.getName());
                    mKinoteatrImageUrls.add(BASE_URL + kinoteatr.getImage());
                }
            initRecyclerView();
                Log.d("Response", "url"+ mKinoteatrImageUrls.get(0));

            }

            @Override
            public void onFailure(Call<JSONResponse> call, Throwable t) {
                Log.e("Response", "FAILURE ON RESPONSE");
            }
        });
            initRecyclerView();
    }

    private void initRecyclerView() {

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        Log.d("RecyclerView adapter", "_____");
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(mKinoteatrImageUrls,mKinoteatrNames,this, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    public void openGridActivity() {
        Intent intent = new Intent(this, GridViewActivity.class);
        startActivity(intent);
    }

}
