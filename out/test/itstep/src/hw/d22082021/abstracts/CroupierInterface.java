package hw.d22082021.abstracts;
@Developer
public interface CroupierInterface<T> {
    T issueCard();
    void shuffleDeck();
    void setNewDeck();
}
