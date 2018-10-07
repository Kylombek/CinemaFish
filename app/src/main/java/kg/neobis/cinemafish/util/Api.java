package kg.neobis.cinemafish.util;

import android.graphics.ColorSpace;

import kg.neobis.cinemafish.cinemasModel.filmsJSON;
import kg.neobis.cinemafish.model.JSONResponse;
import kg.neobis.cinemafish.model.Result;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface Api {
    @GET("kinoteatrs_load")
    Call<JSONResponse> getJSON();
    @GET("kinoafisha_load")
    Call<filmsJSON> getJSONfilms();






}
