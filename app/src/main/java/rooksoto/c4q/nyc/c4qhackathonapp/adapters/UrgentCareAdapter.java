package rooksoto.c4q.nyc.c4qhackathonapp.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.Arrays;
import java.util.List;

import rooksoto.c4q.nyc.c4qhackathonapp.R;
import rooksoto.c4q.nyc.c4qhackathonapp.viewholders.FacilityLocationViewHolder;
import rooksoto.c4q.nyc.c4qhackathonapp.model.FacilityLocation;

/**
 * Created by akashaarcher on 2/18/17.
 */

public class UrgentCareAdapter extends RecyclerView.Adapter {

    private List<FacilityLocation> urgLocations = Arrays.asList(
            new FacilityLocation("NYU Free Clinic", "Manhattan", R.string.nyu_clinic_address, "917.544.0735"),
            new FacilityLocation("Weill Cornell", "Manhattan", R.string.weill_cornell_address, "646.962.9222"),
            new FacilityLocation("Mount Sinai Hospital: East Harlem Outreach", "Manhattan", R.string.mount_sinai_address, "626.942.6519"),
            new FacilityLocation("St. Anthony's Free Clinic", "Bronx", R.string.st_anthonys_address, "718.401.9705"),
            new FacilityLocation("Einstein Community Health Outreach", "Bronx", R.string.echo_clinic_address, "800.836.1316"),
            new FacilityLocation("The Ryan Center: UWS", "Manhattan", R.string.ryan_clinic_uws, "212-749-1820"),
            new FacilityLocation("The Ryan Center: LES", "Manhattan", R.string.ryan_clinic_les, "212-477-8500"),
            new FacilityLocation("The Ryan Center: Hell's Kitchen", "Manhattan", R.string.ryan_clinic_hk, "212-265-4500"),
            new FacilityLocation("Callen-Lorde Community Health Center", "Manhattan", R.string.callen_lorde_clinic_address, "212-271-7200"),
            new FacilityLocation("Charles B. Wang Community Health Center", "Manhattan", R.string.charles_wang_clinic_address_chtwn, "(212) 379-6998"),
            new FacilityLocation("Charles B. Wang Community Health Center", "Manhattan", R.string.charles_wang_clinic_address_flushing, "(718) 886-1200")
    );


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new FacilityLocationViewHolder(parent);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        FacilityLocationViewHolder viewHolder = (FacilityLocationViewHolder) holder;
        FacilityLocation urgentCareLocationList = urgLocations.get(position);
        viewHolder.bind(urgentCareLocationList);
    }


    @Override
    public int getItemCount() {
        return urgLocations.size();
    }


}
