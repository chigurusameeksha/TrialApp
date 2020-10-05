package rooksoto.c4q.nyc.c4qhackathonapp.HhcData.api;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import rooksoto.c4q.nyc.c4qhackathonapp.HhcData.model.HhcData;
import rooksoto.c4q.nyc.c4qhackathonapp.HhcData.model.HhcFacilityLocation;

/**
 * Created by rook on 2/19/17.
 */

public class HhcClient {

    private final String API_URL = "https://data.cityofnewyork.us/";

    private static HhcClient instance;
    private final HhcApi api;

    public static HhcClient getInstance() {
        if (instance == null) {
            instance = new HhcClient();
        }
        return instance;
    }

    private HhcClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        api = retrofit.create(HhcApi.class);
    }

    public Call<List<HhcData>> getData() {
        return api.getDataSet();
    }


    public Call<List<HhcFacilityLocation>> getHhcAcuteLocations() {
        return api.getHhcAcuteLocations();
    }

    public Call<List<HhcFacilityLocation>> getHhcChildCareLocations() {
        return api.getHhcChildCareLocations();
    }


}
