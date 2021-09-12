package hw.d06092021_p2.GoF.behavioral.Observer;

import java.util.ArrayList;
import java.util.List;

public class VacancySite implements Observable {
    List<String> vacancies = new ArrayList<>();

    List<Observer> subscribers = new ArrayList<>();

    public void addVacancy(String vacancy) {
        this.vacancies.add(vacancy);
        notifyObservers();
    }

    public void removeVacansy(String vacancy) {
        this.vacancies.remove(vacancy);
        notifyObservers();
    }
    @Override
    public void addObserver(Observer observer) {
        this.subscribers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        this.subscribers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for(Observer observer : subscribers) {
            observer.handleEvent(this.vacancies);
        }

    }

}
