package patterns;

public interface Observable {
    void attachObserver(Observer o);
    void detachObserver(Observer o);
    void notifyObservers();
}
