package rooksoto.c4q.nyc.c4qhackathonapp;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import rooksoto.c4q.nyc.c4qhackathonapp.fragments.EstimateCostFragment;
import rooksoto.c4q.nyc.c4qhackathonapp.fragments.FavoritesFragment;
import rooksoto.c4q.nyc.c4qhackathonapp.fragments.FindServicesFragment;
import rooksoto.c4q.nyc.c4qhackathonapp.fragments.MedicaidMedicareFragment;
import rooksoto.c4q.nyc.c4qhackathonapp.fragments.NearMeFragment;
import rooksoto.c4q.nyc.c4qhackathonapp.fragments.ProfileFragment;

/**
 * Created by rook on 2/18/17.
 */

public class NavActivity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener {

    ProfileFragment profileFragment = new ProfileFragment();
    FindServicesFragment findServicesFragment = new FindServicesFragment();
    FavoritesFragment favsFragment = new FavoritesFragment();
    EstimateCostFragment estimateCostFragment = new EstimateCostFragment();
    MedicaidMedicareFragment medicaidMedicareFragment = new MedicaidMedicareFragment();
    NearMeFragment nearMeFragment = new NearMeFragment();
    private ActionBarDrawerToggle toggle;
    private DrawerLayout drawerLayout;
    private Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close);

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        try {
            loadFragment();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        toggle.syncState();
    }

    private void loadFragment() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        String fragmentName = getIntent().getExtras().getString("passed_fragment");
        Fragment fragment = (Fragment) Class.forName(fragmentName).newInstance();
        getSupportFragmentManager().beginTransaction().replace(R.id.fl_fragment_host, fragment).commit();

    }

    @Override
    void loadEstimateCost() {
        super.loadEstimateCost();
    }

    @Override
    void loadFavorites() {
        super.loadFavorites();
    }

    @Override
    void loadEmergencyUrgent() {
        super.loadEmergencyUrgent();
    }

    @Override
    void loadFindServices() {
        super.loadFindServices();
    }

    @Override
    void loadProfile() {
        super.loadProfile();
    }


    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case R.id.nav_profile:
                toolbar.setTitle(R.string.profile);
                FragmentTransaction profileFragTransaction = getSupportFragmentManager().beginTransaction();
                profileFragTransaction.replace(R.id.fl_fragment_host, profileFragment);
                profileFragTransaction.commit();
                break;
            case R.id.nav_find_svc:
                FragmentTransaction serviceFragTransaction = getSupportFragmentManager().beginTransaction();
                serviceFragTransaction.replace(R.id.fl_fragment_host, findServicesFragment);
                serviceFragTransaction.commit();
                break;
            case R.id.nav_emrgency_urgent:
                toolbar.setTitle(R.string.emergency_urgent);
                Intent intent = new Intent(this, TabActivity.class);
                startActivity(intent);
                break;
            case R.id.nav_favorite:
                FragmentTransaction favFragTransaction = getSupportFragmentManager().beginTransaction();
                favFragTransaction.replace(R.id.fl_fragment_host, favsFragment);
                favFragTransaction.commit();
                break;
            case R.id.nav_estimated_cost:
                FragmentTransaction estimatedFragTransaction = getSupportFragmentManager().beginTransaction();
                estimatedFragTransaction.replace(R.id.fl_fragment_host, estimateCostFragment);
                estimatedFragTransaction.commit();
                break;
            case R.id.nav_medicaid:
                toolbar.setTitle(R.string.medicaid_medicare);
                FragmentTransaction medFragTransaction = getSupportFragmentManager().beginTransaction();
                medFragTransaction.replace(R.id.fl_fragment_host, medicaidMedicareFragment);
                medFragTransaction.commit();
                break;
            case R.id.nav_near:
                toolbar.setTitle(R.string.near_me);
                FragmentTransaction nearMeFragTransaction = getSupportFragmentManager().beginTransaction();
                nearMeFragTransaction.replace(R.id.fl_fragment_host, nearMeFragment);
                nearMeFragTransaction.commit();
                break;


        }
        return true;
    }
}
