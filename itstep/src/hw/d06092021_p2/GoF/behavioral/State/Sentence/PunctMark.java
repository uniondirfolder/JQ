package hw.d06092021_p2.GoF.behavioral.State.Sentence;

public class PunctMark implements State {
    Sentence sentence;

    public PunctMark(Sentence sentence) {
        this.sentence = sentence;
    }

    @Override
    public String getName() {
        return "\'Punctuation mark\'";
    }

    @Override
    public String next() {
        return "space";
    }

    @Override
    public String toString() {
        return "punctuation mark";
    }
}
