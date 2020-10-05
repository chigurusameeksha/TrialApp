package rooksoto.c4q.nyc.c4qhackathonapp.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import rooksoto.c4q.nyc.c4qhackathonapp.R;
import rooksoto.c4q.nyc.c4qhackathonapp.model.FacilityLocation;

/**
 * Created by akashaarcher on 2/18/17.
 */

public class FacilityLocationViewHolder extends RecyclerView.ViewHolder {

    private View view;
    private TextView tvFacilityName;
    private TextView tvBorough;
    private TextView tvAddress;
    private TextView tvPhone;


    public FacilityLocationViewHolder(ViewGroup parent) {
        super(inflateView(parent));
        view = itemView;
        tvFacilityName = (TextView) view.findViewById(R.id.urg_facility_name);
        tvBorough = (TextView) view.findViewById(R.id.urg_borough);
        tvAddress = (TextView) view.findViewById(R.id.urg_address);
        tvPhone = (TextView) view.findViewById(R.id.urg_phone);
    }


    private static View inflateView(ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return inflater.inflate(R.layout.facility_location_item, parent, false);
    }


    public void bind(FacilityLocation location) {
        tvFacilityName.setText(location.getName());
        tvBorough.setText(location.getBorough());
        tvAddress.setText(location.getAddress());
        tvPhone.setText(location.getPhone());
    }

}
