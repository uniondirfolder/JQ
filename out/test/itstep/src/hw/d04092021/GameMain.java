package hw.d04092021;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

@Developer
public class GameMain {

    public static void main(String[] args) {
        GameView gw = new GameView();

        File dir = new File(GameOptions.GAME_FOLDER.value);
        if (dir.mkdir()) {
            gw.other("Ваше имя ?");
            new FileManager<Gamer>().writeFileSerialize(GameOptions.FILE_USER.value, new Gamer(gw.answer(), 0));
        }

        Gamer gamer = new FileManager<Gamer>().readFileDeSerialize(GameOptions.FILE_USER.value);
        ArrayList<Question> questions = Question.readCSV(GameOptions.FILE_QUESTIONS.value);

        String word = "";

        while (!word.equals("стоп")) {
            Collections.shuffle(questions);
            for (int i = 0; i < questions.size(); i++) {
                Question q = questions.get(i);
                gw.question(q);
                gw.other("ответ (печатаем) > ");
                word = gw.answer();
                gw.other("***********************");
                if (word.equals("стоп"))
                    break;
                if (word.equals(q.getAnswer())) {
                    gamer.setRightAnswers(gamer.getRightAnswers() + 1);
                    gw.other("верно");
                }
                else {
                    gw.other("неверно");
                }
                gw.other("счет: " + gamer.getRightAnswers());
                gw.other("***********************");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        new FileManager<Gamer>().writeFileSerialize(GameOptions.FILE_USER.value, gamer);
    }
}
