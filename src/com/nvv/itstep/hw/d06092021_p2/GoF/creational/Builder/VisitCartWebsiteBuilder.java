package com.nvv.itstep.hw.d06092021_p2.GoF.creational.Builder;

public class VisitCartWebsiteBuilder extends WebSiteBuilder {

    @Override
    void buildName() {
        website.setName("VisitCart web site");
    }

    @Override
    void buildCms() {
        website.setCms(Cms.WORDPRESS);
    }

    @Override
    void buildPrice() {
        website.setPrice(100);
    }
}
