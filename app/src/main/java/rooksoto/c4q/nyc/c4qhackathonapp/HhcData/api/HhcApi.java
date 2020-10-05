package rooksoto.c4q.nyc.c4qhackathonapp.HhcData.api;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import rooksoto.c4q.nyc.c4qhackathonapp.HhcData.model.HhcData;
import rooksoto.c4q.nyc.c4qhackathonapp.HhcData.model.HhcFacilityLocation;

/**
 * Created by rook on 2/19/17.
 */

public interface HhcApi {

    @GET("resource/ujy7-x749.json")
    Call<List<HhcData>> getDataSet();


    @GET("resource/w7a6-9xrz.json?facility_type=Acute%20Care%20Hospital")
    Call<List<HhcFacilityLocation>> getHhcAcuteLocations();
          //(@Query("facility_type") String facilityType);

    @GET("resource/w7a6-9xrz.json?facility_type=Child%20Health%20Center")
    Call<List<HhcFacilityLocation>> getHhcChildCareLocations();
         //(@Query("facility_type") String facilityType);





}
