package rooksoto.c4q.nyc.c4qhackathonapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by rook on 2/18/17.
 */

public class BaseActivity extends AppCompatActivity {

    public static final String BASE_PACKAGE = "rooksoto.c4q.nyc.c4qhackathonapp.fragments.";

    void loadEstimateCost() {
        Intent intent = new Intent(this, NavActivity.class);
        intent.putExtra("passed_fragment", BASE_PACKAGE + "EstimateCostFragment");
        startActivity(intent);
    }

    void loadFavorites() {
        Intent intent = new Intent(this, NavActivity.class);
        intent.putExtra("passed_fragment", BASE_PACKAGE + "FavoritesFragment");
        startActivity(intent);
    }

    void loadEmergencyUrgent() {
        Intent intent = new Intent(this, TabActivity.class);
        startActivity(intent);
    }

    void loadFindServices() {
        Intent intent = new Intent(this, NavActivity.class);
        intent.putExtra("passed_fragment", BASE_PACKAGE + "FindServicesFragment");
        startActivity(intent);
    }

    void loadProfile() {
        Intent intent = new Intent(this, NavActivity.class);
        intent.putExtra("passed_fragment", BASE_PACKAGE + "ProfileFragment");
        startActivity(intent);
    }
}
