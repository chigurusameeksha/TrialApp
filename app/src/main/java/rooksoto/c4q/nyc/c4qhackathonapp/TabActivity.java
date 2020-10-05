package rooksoto.c4q.nyc.c4qhackathonapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import rooksoto.c4q.nyc.c4qhackathonapp.adapters.ViewPagerAdapter;
import rooksoto.c4q.nyc.c4qhackathonapp.fragments.EstimateCostFragment;
import rooksoto.c4q.nyc.c4qhackathonapp.fragments.FavoritesFragment;
import rooksoto.c4q.nyc.c4qhackathonapp.fragments.FindServicesFragment;
import rooksoto.c4q.nyc.c4qhackathonapp.fragments.MedicaidMedicareFragment;
import rooksoto.c4q.nyc.c4qhackathonapp.fragments.NearMeFragment;
import rooksoto.c4q.nyc.c4qhackathonapp.fragments.ProfileFragment;

/**
 * Created by akashaarcher on 2/18/17.
 */

public class TabActivity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener{

    FragmentPagerAdapter fragmentPagerAdapter;
    TabLayout tabLayout;

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
        setContentView(R.layout.activity_tab);

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager);
        fragmentPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(fragmentPagerAdapter);

        tabLayout = (TabLayout) findViewById(R.id.sliding_tabs);

        viewPager.setCurrentItem(0);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.sliding_tabs);
        tabLayout.setupWithViewPager(viewPager);
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close);

    }

    private void loadFragment() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        String fragmentName = getIntent().getExtras().getString("passed_fragment_two");
        Fragment fragment = (Fragment) Class.forName(fragmentName).newInstance();
        getSupportFragmentManager().beginTransaction().replace(R.id.tab_frag_layout, fragment).commit();

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
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        toggle.syncState();
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case R.id.nav_profile:
                FragmentTransaction profileFragTransaction = getSupportFragmentManager().beginTransaction();
                profileFragTransaction.replace(R.id.tab_frag_layout, profileFragment);
                profileFragTransaction.commit();
                break;
            case R.id.nav_find_svc:
                FragmentTransaction serviceFragTransaction = getSupportFragmentManager().beginTransaction();
                serviceFragTransaction.replace(R.id.tab_frag_layout, findServicesFragment);
                serviceFragTransaction.commit();
                break;
            case R.id.nav_emrgency_urgent:
                Intent intent = new Intent(this, TabActivity.class);
                startActivity(intent);
                break;
            case R.id.nav_favorite:
                FragmentTransaction favFragTransaction = getSupportFragmentManager().beginTransaction();
                favFragTransaction.replace(R.id.tab_frag_layout, favsFragment);
                favFragTransaction.commit();
                break;
            case R.id.nav_estimated_cost:
                FragmentTransaction estimatedFragTransaction = getSupportFragmentManager().beginTransaction();
                estimatedFragTransaction.replace(R.id.tab_frag_layout, estimateCostFragment);
                estimatedFragTransaction.commit();
                break;
            case R.id.nav_medicaid:
                FragmentTransaction medFragTransaction = getSupportFragmentManager().beginTransaction();
                medFragTransaction.replace(R.id.tab_frag_layout, medicaidMedicareFragment);
                medFragTransaction.commit();
                break;
            case R.id.nav_near:
                FragmentTransaction nearMeFragTransaction = getSupportFragmentManager().beginTransaction();
                nearMeFragTransaction.replace(R.id.tab_frag_layout, nearMeFragment);
                nearMeFragTransaction.commit();
                break;


        }
        return true;
    }
}
