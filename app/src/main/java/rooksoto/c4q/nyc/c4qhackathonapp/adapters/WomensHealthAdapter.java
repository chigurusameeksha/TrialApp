package rooksoto.c4q.nyc.c4qhackathonapp.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.Arrays;
import java.util.List;

import rooksoto.c4q.nyc.c4qhackathonapp.R;
import rooksoto.c4q.nyc.c4qhackathonapp.model.FacilityLocation;
import rooksoto.c4q.nyc.c4qhackathonapp.viewholders.FacilityLocationViewHolder;

/**
 * Created by akashaarcher on 2/19/17.
 */

public class WomensHealthAdapter extends RecyclerView.Adapter {

    private List<FacilityLocation> whLocations = Arrays.asList(
            new FacilityLocation("Planned Parenthood", "Brooklyn", R.string.planned_parenthood_brooklyn, "917.544.0735"),
            new FacilityLocation("Planned Parenthood", "Manhattan", R.string.planned_parenthood_manhattan, "646.962.9222"),
            new FacilityLocation("Planned Parenthood", "Staten Island", R.string.planned_parenthood_staten_island, "626.942.6519"),
            new FacilityLocation("Planned Parenthood", "Queens", R.string.planned_parenthood_queens, "718.401.9705"),
            new FacilityLocation("Planned Parenthood", "Bronx", R.string.planned_parenthood_bronx, "800.836.1316"),
            new FacilityLocation("Bellevue Hospital: Reproductive Choice Clinic", "Manhattan", R.string.bellevue, "212.562.5796"),
            new FacilityLocation("Columbia University: Faculty Practice", "Manhattan", R.string.columbia, "212.305.9368"),
            new FacilityLocation("Charles B. Wang Community Health Center", "Manhattan", R.string.charles_wang_clinic_address_chtwn, "(212) 379-6998"),
            new FacilityLocation("Charles B. Wang Community Health Center", "Manhattan", R.string.charles_wang_clinic_address_flushing, "(718) 886-1200")

    );

//    if(getFacitlytyp.equals("bldjfa")){
//        wholocatoin.add();
//    }



    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new FacilityLocationViewHolder(parent);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        FacilityLocationViewHolder viewHolder = (FacilityLocationViewHolder) holder;
        FacilityLocation womensHealthLocationList = whLocations.get(position);
        viewHolder.bind(womensHealthLocationList);
    }

    @Override
    public int getItemCount() {
        return whLocations.size();
    }
}
