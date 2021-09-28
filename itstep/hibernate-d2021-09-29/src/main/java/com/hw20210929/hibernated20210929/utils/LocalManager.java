package com.hw20210929.hibernated20210929.utils;

import com.hw20210929.hibernated20210929.Lang;

import java.util.Locale;

public class LocalManager {
    private static Lang currentLang;

    public static Lang getCurrentLang() {
        return currentLang;
    }

    public static void setCurrentLang(Lang currentLang) {
        LocalManager.currentLang = currentLang;
    }

    public static final Locale EN_LOCALE = new Locale("en");
    public static final Locale RU_LOCALE = new Locale("ru");
    public static final String RU_CODE = "RU_CODE";
    public static final String EN_CODE = "EN_CODE";


}
