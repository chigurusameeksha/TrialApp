package rooksoto.c4q.nyc.c4qhackathonapp.HhcData.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by rook on 2/19/17.
 */

public class HhcData {

    @SerializedName("fee")
    @Expose
    private String fee;
    @SerializedName("hhc_options_reduced_fee_level")
    @Expose
    private String hhcOptionsReducedFeeLevel;
    @SerializedName("service")
    @Expose
    private String service;

    public String getFee() {
        return fee;
    }

    public void setFee(String fee) {
        this.fee = fee;
    }

    public String getHhcOptionsReducedFeeLevel() {
        return hhcOptionsReducedFeeLevel;
    }

    public void setHhcOptionsReducedFeeLevel(String hhcOptionsReducedFeeLevel) {
        this.hhcOptionsReducedFeeLevel = hhcOptionsReducedFeeLevel;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

}

