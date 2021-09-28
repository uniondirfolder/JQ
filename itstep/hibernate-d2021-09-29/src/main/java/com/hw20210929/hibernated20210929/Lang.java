package com.hw20210929.hibernated20210929;

import java.util.Locale;

public class Lang {
    private String code;
    private String name;
    private Locale locale;
    private int index;

    public Lang(String code, String name, Locale locale, int index) {
        this.code = code;
        this.name = name;
        this.locale = locale;
        this.index = index;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Locale getLocale() {
        return locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    @Override
    public String toString() {
        return name;
    }
}
