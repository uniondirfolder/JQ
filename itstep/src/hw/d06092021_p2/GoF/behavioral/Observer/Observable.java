package hw.d06092021_p2.GoF.behavioral.Observer;

public interface Observable {
    public void addObserver(Observer observer);
    
    public void removeObserver(Observer observer);
    
    public void notifyObservers();
}
