package edu.salleurl.ls30394.studentsregister.Model;

import android.util.Log;

/**
 * Created by avoge on 22/02/2017.
 */

public class User {

    public static final int YOUNGER_THAN_18 = 0;
    public static final int BETWEEN_18_65 = 1;
    public static final int OLDER_THAN_65 = 2;

    /**
     * Name of the registered student
     */
    private String userName;

    /**
     * Email of the registered student
     */
    private String userEmail;

    /**
     * Password of the registered student
     */
    private String userPassword;

    /**
     * Tells if the registered student owns a laptop
     */
    private boolean hasLaptop;

    /**
     * Tells if the registered student owns an Android Mobile Device
     */
    private boolean hasAndPhone;

    /**
     * Tells the age group of the registered student
     * Either YOUNGER_THAN_18, BETWEEN_18_65 or OLDER_THAN_65
     */
    private int ageGroup;

    /**
     * The registered user's mobile device
     */
    private Phone cellPhone;

    /**
     * Builds a User object
     * @param userName the user's name
     */
    public User(String userName) {
        this.userName = userName;
    }

    /**
     * @return The user's name
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Sets a new name for the user
     * @param userName The new user's name
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return The user's email
     */
    public String getUserEmail() {
        return userEmail;
    }

    /**
     * Sets a new email for the user
     * @param userEmail The new user's email
     */
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    /**
     * @return The user's password
     */
    public String getUserPassword() {
        return userPassword;
    }

    /**
     * Sets a new password for the user
     * @param userPassword The new user's password
     */
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    /**
     * @return True if the user owns a laptop
     */
    public boolean hasLaptop() {
        return hasLaptop;
    }

    /**
     * Sets if the student has a laptop or not
     * @param hasLaptop
     */
    public void setHasLaptop(boolean hasLaptop) {
        this.hasLaptop = hasLaptop;
    }

    /**
     * @return True if the user owns an Android Mobile Device
     */
    public boolean hasAndPhone() {
        return hasAndPhone;
    }

    /**
     * Sets if the student has an android mobile device or not
     * @param hasAndPhone
     */
    public void setHasAndPhone(boolean hasAndPhone) {
        this.hasAndPhone = hasAndPhone;
    }

    /**
     * @return The age group in which the student is in
     */
    public int getAgeGroup() {
        return ageGroup;
    }

    /**
     * Sets a new age group for the student
     * @param ageGroup The new user's age group
     */
    public void setAgeGroup(int ageGroup) {
        this.ageGroup = ageGroup;
    }

    /**
     * @return The user's cell phone
     */
    public Phone getCellPhone() {
        return cellPhone;
    }

    /**
     * Sets a new cellphone for the user
     * @param cellPhone The new user's cellphone
     */
    public void setCellPhone(Phone cellPhone) {
        this.cellPhone = cellPhone;
    }

    /**
     * Displays all the user's information on the Android Monitor
     */
    public void logInfo(){
        Log.d(" ", "//------------------------------------------------------------------------//");
        Log.d("User Name", userName);
        Log.d("User Email", userEmail);
        Log.d("User Password", userPassword);
        Log.d("User has Laptop", Boolean.toString(hasLaptop));
        Log.d("User has Android Phone", Boolean.toString(hasAndPhone));
        if(hasAndPhone)
            Log.d("User's Phone API Level",
                    Integer.toString(((UserAndroidPhone)cellPhone).getAndroidVersion()));
    }
}
