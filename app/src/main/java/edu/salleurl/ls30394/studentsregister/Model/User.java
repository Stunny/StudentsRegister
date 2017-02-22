package edu.salleurl.ls30394.studentsregister.Model;

/**
 * Created by avoge on 22/02/2017.
 */

public class User {

    public static final int YOUNGER_THAN_18 = 0;
    public static final int BETWEEN_18_65 = 1;
    public static final int OLDER_THAT_65 = 2;

    private String userName;
    private String userEmail;
    private String userPassword;

    private boolean hasLaptop;
    private boolean hasAndPhone;

    private int ageGroup;

    private Phone cellPhone;

    public User(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public boolean isHasLaptop() {
        return hasLaptop;
    }

    public void setHasLaptop(boolean hasLaptop) {
        this.hasLaptop = hasLaptop;
    }

    public boolean isHasAndPhone() {
        return hasAndPhone;
    }

    public void setHasAndPhone(boolean hasAndPhone) {
        this.hasAndPhone = hasAndPhone;
    }

    public int getAgeGroup() {
        return ageGroup;
    }

    public void setAgeGroup(int ageGroup) {
        this.ageGroup = ageGroup;
    }

    public Phone getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(Phone cellPhone) {
        this.cellPhone = cellPhone;
    }
}
