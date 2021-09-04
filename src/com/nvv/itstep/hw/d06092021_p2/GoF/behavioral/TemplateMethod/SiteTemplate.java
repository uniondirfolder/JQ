package com.nvv.itstep.hw.d06092021_p2.GoF.behavioral.TemplateMethod;

public abstract class SiteTemplate {
    public void getSite() {
        getHeader();
        getContent();
        getFooter();
    }

    public void getHeader() {
        System.out.println("Header");
    }

    public abstract void getContent();

    public void getFooter() {
        System.out.println("Footer");
    }
}
