package rooksoto.c4q.nyc.c4qhackathonapp;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class HomeActivity extends BaseActivity implements View.OnClickListener{

    TextView tvFindServices;
    TextView tvEmergencyUrgent;
    TextView tvFavorites;
    TextView tvEstimateCost;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initViews();
        Picasso.with(this).load(R.drawable.bckgrnd).fit().centerCrop().into(imageView);
    }

    @Override
    protected void onResume() {
        super.onResume();
        setListeners();
    }

    private void initViews() {
        tvFindServices = (TextView) findViewById(R.id.tv_find_svc);
        tvEmergencyUrgent = (TextView) findViewById(R.id.tv_emergency_urgent);
        tvFavorites = (TextView) findViewById(R.id.tv_favorites);
        tvEstimateCost = (TextView) findViewById(R.id.tv_estimate_cost);
        imageView = (ImageView) findViewById(R.id.iv_home_background);
    }

    private void setListeners() {
        tvFindServices.setOnClickListener(this);
        tvEmergencyUrgent.setOnClickListener(this);
        tvFavorites.setOnClickListener(this);
        tvEstimateCost.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_find_svc:
                loadFindServices();
                break;
            case R.id.tv_emergency_urgent:
                loadEmergencyUrgent();
                break;
            case R.id.tv_favorites:
                loadFavorites();
                break;
            case R.id.tv_estimate_cost:
                loadEstimateCost();
                break;
            default:
                break;
        }
    }
}