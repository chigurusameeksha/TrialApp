package rooksoto.c4q.nyc.c4qhackathonapp.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import rooksoto.c4q.nyc.c4qhackathonapp.NavActivity;
import rooksoto.c4q.nyc.c4qhackathonapp.R;
import rooksoto.c4q.nyc.c4qhackathonapp.TabActivity;

/**
 * Created by rook on 2/18/17.
 */

public class FavoritesFragment extends Fragment implements View.OnClickListener{

    private ImageButton faveBtn1;
    private ImageButton faveBtn2;
    private ImageButton faveBtn3;

    private TextView name1;
    private TextView name2;
    private TextView name3;

    private RelativeLayout location1;
    private RelativeLayout location2;
    private RelativeLayout location3;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_favorites,container,false);

        try {
            ((NavActivity) view.getContext()).getSupportActionBar().setTitle(R.string.my_favs);
            ((TabActivity) view.getContext()).getSupportActionBar().setTitle(R.string.my_favs);
        } catch (Exception e){
            e.printStackTrace();
        }

        faveBtn1 = (ImageButton) view.findViewById(R.id.fave_btn);
        faveBtn2 = (ImageButton) view.findViewById(R.id.fave_btn2);
        faveBtn3 = (ImageButton) view.findViewById(R.id.fave_btn3);

        name1 = (TextView) view.findViewById(R.id.urg_facility_name);
        name2 = (TextView) view.findViewById(R.id.urg_facility_name2);
        name3 = (TextView) view.findViewById(R.id.urg_facility_name3);

        location1 = (RelativeLayout) view.findViewById(R.id.fave_location1);
        location2 = (RelativeLayout) view.findViewById(R.id.fave_location2);
        location3 = (RelativeLayout) view.findViewById(R.id.fave_location3);

        activateButtons();

        return view;

    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    public void activateButtons() {
        faveBtn1.setOnClickListener(this);
        faveBtn2.setOnClickListener(this);
        faveBtn3.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        Animation animation = new AlphaAnimation(1.0f, 0.0f);
        animation.setDuration(1750);

        String place1 = name1.getText().toString();
        String place2 = name2.getText().toString();
        String place3 = name3.getText().toString();

        switch (view.getId()) {
            case R.id.fave_btn:
                Toast.makeText(getContext(), place1 + " has been removed from your favorites", Toast.LENGTH_SHORT).show();
                location1.startAnimation(animation);
                location1.setVisibility(View.GONE);
                break;

            case R.id.fave_btn2:
                Toast.makeText(getContext(), place2 + " has been removed from your favorites", Toast.LENGTH_SHORT).show();
                location2.startAnimation(animation);
                location2.setVisibility(View.GONE);
                break;

            case R.id.fave_btn3:
                Toast.makeText(getContext(), place3 + " has been removed from your favorites", Toast.LENGTH_SHORT).show();
                location3.startAnimation(animation);
                location3.setVisibility(View.GONE);
                break;
        }

    }
}
