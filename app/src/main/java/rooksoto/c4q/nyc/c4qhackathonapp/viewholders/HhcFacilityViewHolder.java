package rooksoto.c4q.nyc.c4qhackathonapp.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import rooksoto.c4q.nyc.c4qhackathonapp.HhcData.model.HhcFacilityLocation;
import rooksoto.c4q.nyc.c4qhackathonapp.R;

/**
 * Created by akashaarcher on 2/19/17.
 */

public class HhcFacilityViewHolder extends RecyclerView.ViewHolder {

    private View view;
    private TextView tvHhcName;
    private TextView tvHhcType;
    private TextView tvHhcBorough;
    private TextView tvHhcStreet;
    private TextView tvHhcCity;
    private TextView tvHhcState;
    private TextView tvHhcZip;
    private TextView tvHhcPhone;


    public HhcFacilityViewHolder(ViewGroup parent) {
        super(inflateView(parent));
        view = itemView;
        tvHhcName = (TextView) view.findViewById(R.id.hhc_facility_name);
        tvHhcType = (TextView) view.findViewById(R.id.hhc_facility_type);
        tvHhcBorough = (TextView) view.findViewById(R.id.hhc_borough);
        tvHhcStreet = (TextView) view.findViewById(R.id.hhc_street);
        tvHhcCity = (TextView) view.findViewById(R.id.hhc_city);
        tvHhcState = (TextView) view.findViewById(R.id.hhc_state);
        tvHhcZip = (TextView) view.findViewById(R.id.hhc_zip);
        tvHhcPhone = (TextView) view.findViewById(R.id.hhc_phone);
    }


    private static View inflateView(ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return inflater.inflate(R.layout.hhc_location_item, parent, false);
    }


    public void bind(HhcFacilityLocation hhcLocation) {
        tvHhcName.setText(hhcLocation.getFacilityName());
        tvHhcType.setText(hhcLocation.getFacilityType());
        tvHhcBorough.setText(hhcLocation.getBorough());
        tvHhcStreet.setText(hhcLocation.getLocation1Location());
        tvHhcCity.setText(hhcLocation.getLocation1City());
        tvHhcState.setText(hhcLocation.getLocation1State());
        tvHhcZip.setText(hhcLocation.getLocation1Zip());
        tvHhcPhone.setText(hhcLocation.getPhone());
    }




}
