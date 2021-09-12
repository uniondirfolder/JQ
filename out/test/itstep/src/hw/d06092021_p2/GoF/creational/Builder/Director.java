package hw.d06092021_p2.GoF.creational.Builder;

public class Director {
    WebSiteBuilder builder;

    public void setBuilder(WebSiteBuilder builder) {
        this.builder = builder;
    }
    
    Website buildWebsite() {
        builder.createWebsite();
        builder.buildName();
        builder.buildCms();
        builder.buildPrice();
        
        Website website = builder.getWebsite();
        
        return website;
    }
}
