package rooksoto.c4q.nyc.c4qhackathonapp.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.List;

import rooksoto.c4q.nyc.c4qhackathonapp.HhcData.model.HhcFacilityLocation;
import rooksoto.c4q.nyc.c4qhackathonapp.viewholders.HhcFacilityViewHolder;

/**
 * Created by akashaarcher on 2/19/17.
 */

public class HhcAcuteAdapter extends RecyclerView.Adapter {


    private HhcFacilityLocation hhcFacilityLocation;
    private List<HhcFacilityLocation> locations;

    public HhcAcuteAdapter(List<HhcFacilityLocation> locations) {
        this.locations = locations; //new ArrayList<>();
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new HhcFacilityViewHolder(parent);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        HhcFacilityViewHolder locationViewHolder = (HhcFacilityViewHolder) holder;
        HhcFacilityLocation hhcFacilityList = locations.get(position);
        locationViewHolder.bind(hhcFacilityList);
    }

    @Override
    public int getItemCount() {
        return locations.size();
    }

}
