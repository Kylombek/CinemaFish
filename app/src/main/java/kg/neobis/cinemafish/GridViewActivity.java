package kg.neobis.cinemafish;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.GridView;

import java.util.ArrayList;

import kg.neobis.cinemafish.cinemasModel.Film;
import kg.neobis.cinemafish.cinemasModel.filmsJSON;
import kg.neobis.cinemafish.ui.GridViewAdapter;
import kg.neobis.cinemafish.util.Network;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GridViewActivity extends AppCompatActivity {
    private final static String BASE_URL = "https://kinoafisha.ua";
    GridView gridView;
    private ArrayList<Film> mFilms;
    private ArrayList<String> mFilmsNames = new ArrayList<>();
    private ArrayList<String> mFilmsImageUrls = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.grid_view);
        initImagesAndTextsMenu();
    }

    private void initImagesAndTextsMenu() {
        Log.d("GridView", "initImagesAndTexts");
        Network.getApiClass().getJSONfilms().enqueue(new Callback<filmsJSON>() {
            @Override
            public void onResponse(Call<filmsJSON> call, Response<filmsJSON> response) {
                mFilms = response.body().getResult();
                for(Film film : mFilms){
                    mFilmsNames.add(film.getName());
                    mFilmsImageUrls.add(BASE_URL + film.getImage().replace("sm_",""));
                }
                initAdapter();
            }

            @Override
            public void onFailure(Call<filmsJSON> call, Throwable t) {
            Log.e("GridViewActivity", "FAILURE ON RESPONSE");
            }
        });
    }
    private void initAdapter() {
        gridView =  findViewById(R.id.gridview);
        GridViewAdapter adapter = new GridViewAdapter(this,mFilmsNames,mFilmsImageUrls);
        gridView.setAdapter(adapter);

    }
    }
