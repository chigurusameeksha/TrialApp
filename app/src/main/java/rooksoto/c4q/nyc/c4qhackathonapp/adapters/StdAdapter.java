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

public class StdAdapter extends RecyclerView.Adapter {

    private List<FacilityLocation> stdLocations = Arrays.asList(
            new FacilityLocation("Central Harlem Clinic", "Manhattan", R.string.health_dept_sexual_harlem, "917.544.0735"),
            new FacilityLocation("Manhattanville Clinic", "Manhattan", R.string.health_dept_sexual_manhattanville, "646.962.9222"),
            new FacilityLocation("Riverside Clinic", "Manhattan", R.string.health_dept_sexual_riverside, "626.942.6519"),
            new FacilityLocation("Morrisania Clinic", "Bronx", R.string.health_dept_sexual_morrisania, "718.401.9705"),
            new FacilityLocation("Crown Heights Clinic", "Brooklyn", R.string.health_dept_sexual_crown_heights, "800.836.1316"),
            new FacilityLocation("Fort Greene Clinic", "Brooklyn", R.string.health_dept_sexual_fort_greene, "212.562.5796"),
            new FacilityLocation("Corona Clinic", "Queens", R.string.health_dept_sexual_corona, "212.305.9368"),
            new FacilityLocation("Jamaica Clinic", "Queens", R.string.health_dept_sexual_jamaica, "(212) 379-6998")
    );


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new FacilityLocationViewHolder(parent);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        FacilityLocationViewHolder viewHolder = (FacilityLocationViewHolder) holder;
        FacilityLocation stdClinicLocationList = stdLocations.get(position);
        viewHolder.bind(stdClinicLocationList);
    }

    @Override
    public int getItemCount() {
        return stdLocations.size();
    }
}