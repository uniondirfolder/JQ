package hw.d06092021_p2.GoF.behavioral.Observer;

public class Program {

    public static void main(String[] args) {
        VacancySite site = new VacancySite();

        site.addVacancy("1 vacancy");
        site.addVacancy("2 vacancy");
        
        Observer subsriber1 = new Subscriber("Igor");
        Observer subsriber2 = new Subscriber("Harry");
        
        site.addObserver(subsriber1);
        site.addObserver(subsriber2);
        
        site.addVacancy("New vacancy");
        site.removeVacansy("1 vacancy");
    }
}
