package rooksoto.c4q.nyc.c4qhackathonapp.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import rooksoto.c4q.nyc.c4qhackathonapp.LocationActivity;
import rooksoto.c4q.nyc.c4qhackathonapp.NavActivity;
import rooksoto.c4q.nyc.c4qhackathonapp.R;
import rooksoto.c4q.nyc.c4qhackathonapp.TabActivity;

/**
 * Created by rook on 2/18/17.
 */

public class FindServicesFragment extends Fragment implements View.OnClickListener {

    private Spinner servicesSpinner;
    private Spinner boroughSpinner;
    private Button searchBtn;
    private String serviceSpinnerValue = "";
    private String boroughSpinnerValue = "";
    public static String SERVICE_KEY = "Service Key";
    public static String BOROUGH_KEY = "Borough Key";
    private ImageView findServiceIV;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_find_services, container, false);

        try {
            ((NavActivity) view.getContext()).getSupportActionBar().setTitle(R.string.find_service);
            ((TabActivity) view.getContext()).getSupportActionBar().setTitle(R.string.find_service);
        } catch (Exception e){
            e.printStackTrace();
        }

        servicesSpinner = (Spinner) view.findViewById(R.id.services_spinner);
        boroughSpinner = (Spinner) view.findViewById(R.id.borough_spinner);
        searchBtn = (Button) view.findViewById(R.id.search_btn);
        findServiceIV = (ImageView) view.findViewById(R.id.serviceIV);


        Picasso.with(view.getContext()).load(R.drawable.steth_two).fit().centerCrop().into(findServiceIV);

        ArrayAdapter<CharSequence> serviceAdapter = ArrayAdapter.createFromResource(view.getContext(),
                R.array.medical_services, android.R.layout.simple_spinner_item);
        serviceAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        servicesSpinner.setAdapter(serviceAdapter);


        ArrayAdapter<CharSequence> boroughAdapter = ArrayAdapter.createFromResource(view.getContext(),
                R.array.borough_list, android.R.layout.simple_spinner_item);
        boroughAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        boroughSpinner.setAdapter(boroughAdapter);


        servicesSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                serviceSpinnerValue = servicesSpinner.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Toast.makeText(getActivity(), "Choose a Service", Toast.LENGTH_SHORT).show();
            }
        });

        boroughSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                boroughSpinnerValue = boroughSpinner.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Toast.makeText(getActivity(), "Choose a Location", Toast.LENGTH_SHORT).show();
            }
        });

        setListeners();
        return view;
    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    private void setListeners() {
        searchBtn.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.search_btn:
                if(serviceSpinnerValue.equals("Please choose a service")) {
                    Toast.makeText(getActivity(), "Please choose a service", Toast.LENGTH_SHORT).show();
                } else  {
                    Intent intent = new Intent(view.getContext(), LocationActivity.class);
                    intent.putExtra(SERVICE_KEY, serviceSpinnerValue);
                    intent.putExtra(BOROUGH_KEY, boroughSpinnerValue);
                    startActivity(intent);
                }
        }
    }

}

