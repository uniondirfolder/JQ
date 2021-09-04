package com.nvv.itstep.hw.d06092021_p2.GoF.creational.Builder;

public abstract class WebSiteBuilder {
    Website website;

    void createWebsite() {
        website = new Website();
    }

    abstract void buildName();
    abstract void buildCms();
    abstract void buildPrice();

    Website getWebsite() {
        return website;
    }
}
