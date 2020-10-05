package rooksoto.c4q.nyc.c4qhackathonapp.model;

/**
 * Created by shannonalexander-navarro on 2/18/17.
 */

public class Profile {

    private Long userIncome;
    private String userName;
    private int familySize;
    private String userPicUrl;
    private String borough;
    private String language;

    public Profile(Long userIncome, String userName, int familySize, String userPicUrl, String borough, String language) {
        this.userIncome = userIncome;
        this.userName = userName;
        this.familySize = familySize;
        this.userPicUrl = userPicUrl;
        this.borough = borough;
        this.language = language;
    }

    public Long getUserIncome() {
        return userIncome;
    }

    public void setUserIncome(Long userIncome) {
        this.userIncome = userIncome;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getFamilySize() {
        return familySize;
    }

    public void setFamilySize(int familySize) {
        this.familySize = familySize;
    }

    public String getUserPicUrl() {
        return userPicUrl;
    }

    public void setUserPicUrl(String userPicUrl) {
        this.userPicUrl = userPicUrl;
    }

    public String getBorough() {
        return borough;
    }

    public void setBorough(String borough) {
        this.borough = borough;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
