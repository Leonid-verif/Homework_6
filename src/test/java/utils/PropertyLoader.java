package test.java.utils;

import java.util.ResourceBundle;

public class PropertyLoader {
    private static ResourceBundle res = ResourceBundle.getBundle("config");
    private static ResourceBundle resSecured = ResourceBundle.getBundle("config");

    public static String loadProperty(String name) {
        return res.getString(name);

    }

    public static String loadSecuredProp(String name) {
        return resSecured.getString(name);


    }
}
