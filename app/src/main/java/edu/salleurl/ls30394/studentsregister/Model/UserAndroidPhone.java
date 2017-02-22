package edu.salleurl.ls30394.studentsregister.Model;

/**
 * Created by avoge on 22/02/2017.
 */

public class UserAndroidPhone extends Phone{

    public static final int JELLY_BEAN = 18;
    public static final int KITKAT = 19;
    public static final int LOLLIPOP = 22;
    public static final int MARSHMALLOW = 23;
    public static final int NOUGAT = 25;

    private int androidVersion;

    public UserAndroidPhone(int androidVersion) {
        this.androidVersion = androidVersion;
    }
}
