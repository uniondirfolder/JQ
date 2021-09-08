package hw.d06092021_p2.GoF.behavioral.State.Sentence;

import java.util.ArrayList;

public class Program {

    public static void main(String[] args) {
        Sentence sentence = new Sentence();
        ArrayList<State> states = new ArrayList<>();
        states.add(new Word(sentence));
        states.add(new Word(sentence));
        states.add(new PunctMark(sentence));
        states.add(new Word(sentence));
        states.add(new Email(sentence));
        states.add(new Word(sentence));
        states.add(new SentenceEnd(sentence));

        StringBuffer result = new StringBuffer();

        for(State state : states) {
            result.append(state.getName());
            result.append(" ");
            result.append(state.next());
            result.append(" ");
        }

        System.out.println(result.toString());
    }
}
