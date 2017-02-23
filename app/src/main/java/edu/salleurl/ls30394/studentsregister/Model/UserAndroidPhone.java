package edu.salleurl.ls30394.studentsregister.Model;

/**
 * Defines an Android Phone
 * @author Alex Vogel
 * @version 1.0.0
 * @last_modified 22/02/2017
 * Created by avoge on 22/02/2017.
 */

public class UserAndroidPhone extends Phone{

    public static final int JELLY_BEAN = 18;
    public static final int KITKAT = 19;
    public static final int LOLLIPOP = 22;
    public static final int MARSHMALLOW = 23;
    public static final int NOUGAT = 25;

    /**
     * API Level of the User's android phone
     */
    private int androidVersion;

    /**
     * Builds a new UserAndroidPhone
     */
    public UserAndroidPhone() {}

    /**
     * Builds a new UserAndroidPhone
     * @param androidVersion API level of the User's Android phone
     */
    public UserAndroidPhone(int androidVersion) {
        this.androidVersion = androidVersion;
    }

    /**
     * @return API level of the User's Android Phone
     */
    public int getAndroidVersion() {
        return androidVersion;
    }

    /**
     * Sets a new API level for the User's Android phone
     * @param androidVersion API level
     */
    public void setAndroidVersion(int androidVersion) {
        this.androidVersion = androidVersion;
    }
}
