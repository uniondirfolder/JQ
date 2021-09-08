package hw.d06092021_p2.GoF.behavioral.TemplateMethod;

public class NewsSite extends SiteTemplate {

    @Override
    public void getContent() {
        System.out.println("News, news, news...");
    }
}
