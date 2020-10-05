package rooksoto.c4q.nyc.c4qhackathonapp.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

import rooksoto.c4q.nyc.c4qhackathonapp.fragments.EmergencyRoomFragment;
import rooksoto.c4q.nyc.c4qhackathonapp.fragments.UrgentCareFragment;

/**
 * Created by akashaarcher on 2/18/17.
 */

public class ViewPagerAdapter extends FragmentPagerAdapter {

    private static int TAB_NUM = 2;
    private ArrayList<String> titles = new ArrayList<>();

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
        titles.add("Emergency Rooms");
        titles.add("Urgent Care");
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                return EmergencyRoomFragment.newInstance(0, "emergFrag");
            case 1:
                return UrgentCareFragment.newInstance(1, "urgFrag");
        }

        return null;
    }

    @Override
    public int getCount() {
        return TAB_NUM;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles.get(position);
    }

}
