package kg.neobis.cinemafish.util;

import kg.neobis.cinemafish.util.Api;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Network {
    private static final String BASE_URL = "http://kinoafisha.ua/ajax/";
    private static Api api = null;
    private static Retrofit retrofit = null;

    public static Api getApiClass() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            api = retrofit.create(Api.class);
        }
        return api;
    }


}
