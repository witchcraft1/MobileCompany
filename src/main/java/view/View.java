package view;

import java.util.Locale;
import java.util.ResourceBundle;

public class View implements Constants{
   // static Locale locale = new Locale("ua", "UA");
    public static final ResourceBundle resourceBundle =
            ResourceBundle.getBundle("message");

    public static void print(String msg){
        System.out.println(msg);
    }

    private static String[] getResBundleStrings(String ...str){
        String[] resBundleStrings = new String[str.length];
        for (int i = 0; i < str.length; i++) {
            resBundleStrings[i] = resourceBundle.getString(str[i]);
        }
        return resBundleStrings;
    }

    public static void showCompanyInfo(String format, String ... rateFormats){
        print(String.format(format, resourceBundle.getString(COMPANY_NAME)));
        for (String rateFormat : rateFormats) {
            print(String.format(rateFormat, getResBundleStrings(RATE, COST_PER_MONTH, SMS,
                    CLIENT_COUNT, INTERNET_MB, MINUTES_WITHIN_NETWORK,
                    MINUTES_TO_OTHER_NETWORK)));
        }
    }
}
