package rooksoto.c4q.nyc.c4qhackathonapp.model;

import android.support.annotation.StringRes;

/**
 * Created by akashaarcher on 2/18/17.
 */

public class FacilityLocation {

    private String name;
    private String borough;
    private Integer address;
    private String phone;


    public FacilityLocation(String name, String borough, @StringRes Integer address, String phone) {
        this.name = name;
        this.borough = borough;
        this.address = address;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBorough() {
        return borough;
    }

    public void setBorough(String borough) {
        this.borough = borough;
    }

    public Integer getAddress() {
        return address;
    }

    public void setAddress(Integer address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

}
