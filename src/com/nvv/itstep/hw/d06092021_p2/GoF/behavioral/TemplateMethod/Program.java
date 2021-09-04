package com.nvv.itstep.hw.d06092021_p2.GoF.behavioral.TemplateMethod;

public class Program {

    public static void main(String[] args) {
        SiteTemplate news = new NewsSite();
        SiteTemplate shop = new ShopSite();

        System.out.println("This is news site:");
        news.getSite();

        System.out.println("==================================\n");
        
        System.out.println("This is site internet shopping:");
        shop.getSite();
    }
}
