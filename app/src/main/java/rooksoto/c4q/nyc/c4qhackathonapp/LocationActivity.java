package rooksoto.c4q.nyc.c4qhackathonapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import rooksoto.c4q.nyc.c4qhackathonapp.HhcData.api.HhcClient;
import rooksoto.c4q.nyc.c4qhackathonapp.HhcData.model.HhcFacilityLocation;
import rooksoto.c4q.nyc.c4qhackathonapp.adapters.HhcAcuteAdapter;
import rooksoto.c4q.nyc.c4qhackathonapp.adapters.PlannedParenthoodAdapter;
import rooksoto.c4q.nyc.c4qhackathonapp.adapters.StdAdapter;
import rooksoto.c4q.nyc.c4qhackathonapp.adapters.UrgentCareAdapter;
import rooksoto.c4q.nyc.c4qhackathonapp.adapters.WomensHealthAdapter;
import rooksoto.c4q.nyc.c4qhackathonapp.fragments.FindServicesFragment;

/**
 * Created by akashaarcher on 2/19/17.
 */

public class LocationActivity extends AppCompatActivity {

    private RecyclerView facilityRv;

    private final String PAP_SERVICE = "Pap Smear";
    private final String BIRTH_CONTROL = "Birth Control";
    private final String EMERGENCY_ROOM = "Emergency Room";
    private final String PEDIATRICIAN = "Pediatrician";
    private final String URGENT_CARE = "Urgent Care";
    private final String STD_TESTING = "STD Testing";
    private final String PPNYC = "Planned Parenthood";

    private final String BROOKLYN = "Brooklyn";
    private final String QUEENS = "Queens";
    private final String BRONX = "Bronx";
    private final String MANHATTAN = "Manhattan";

    HhcClient hhcClient;
    private HhcAcuteAdapter hhcAdapter;
    private static final String TAG = "Locations";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);

        facilityRv = (RecyclerView) findViewById(R.id.facility_rv);
        facilityRv.setLayoutManager(new LinearLayoutManager(this));

        String service = getIntent().getStringExtra(FindServicesFragment.SERVICE_KEY);
        String borough = getIntent().getStringExtra(FindServicesFragment.BOROUGH_KEY);

        if (service.equals(PAP_SERVICE) || service.equals(BIRTH_CONTROL)) {
            facilityRv.setAdapter(new WomensHealthAdapter());
        } else if (service.equals(URGENT_CARE)) {
            facilityRv.setAdapter(new UrgentCareAdapter());
        } else if (service.equals(STD_TESTING)) {
            facilityRv.setAdapter(new StdAdapter());
        } else if (service.equals(PPNYC)) {
            facilityRv.setAdapter(new PlannedParenthoodAdapter());
        }

        loadHhcAcuteLocations();
        loadHhcChildClinicLocations();
    }


    private void loadHhcAcuteLocations() {

        hhcClient = HhcClient.getInstance();
        Call<List<HhcFacilityLocation>> call = hhcClient.getHhcAcuteLocations();

        call.enqueue(new Callback<List<HhcFacilityLocation>>() {

            @Override
            public void onResponse(Call<List<HhcFacilityLocation>> call, Response<List<HhcFacilityLocation>> response) {
                List<HhcFacilityLocation> hhcLocationList = response.body();
                hhcAdapter = new HhcAcuteAdapter(hhcLocationList);

                String service = getIntent().getStringExtra(FindServicesFragment.SERVICE_KEY);
                String borough = getIntent().getStringExtra(FindServicesFragment.BOROUGH_KEY);

                if (service.equals(EMERGENCY_ROOM)) {
                    facilityRv.setAdapter(hhcAdapter);
                }

                hhcAdapter.notifyDataSetChanged();

                //   facilityRv.setAdapter(hhcAdapter);

                Log.d(TAG, "Emergency rooms!!! " + hhcLocationList.size());
            }

            @Override
            public void onFailure(Call<List<HhcFacilityLocation>> call, Throwable t) {
            }
        });
    }


    private void loadHhcChildClinicLocations() {

        hhcClient = HhcClient.getInstance();
        Call<List<HhcFacilityLocation>> call = hhcClient.getHhcChildCareLocations();

        call.enqueue(new Callback<List<HhcFacilityLocation>>() {

            @Override
            public void onResponse(Call<List<HhcFacilityLocation>> call, Response<List<HhcFacilityLocation>> response) {
                List<HhcFacilityLocation> hhcLocationList = response.body();
                hhcAdapter = new HhcAcuteAdapter(hhcLocationList);

                String service = getIntent().getStringExtra(FindServicesFragment.SERVICE_KEY);
                String borough = getIntent().getStringExtra(FindServicesFragment.BOROUGH_KEY);

                if (service.equals(PEDIATRICIAN)) {
                    facilityRv.setAdapter(hhcAdapter);
                }

                hhcAdapter.notifyDataSetChanged();

                Log.d(TAG, "Child care!!! " + hhcLocationList.size());
            }

            @Override
            public void onFailure(Call<List<HhcFacilityLocation>> call, Throwable t) {
            }
        });
    }

}



