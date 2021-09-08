package hw.d04092021;


import java.util.Objects;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.*;

@Developer
public class Question implements Serializable {

    private String question;
    private String answer;
    private String var1;
    private String var2;
    private String var3;

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getVar1() {
        return var1;
    }

    public void setVar1(String var1) {
        this.var1 = var1;
    }

    public String getVar2() {
        return var2;
    }

    public void setVar2(String var2) {
        this.var2 = var2;
    }

    public String getVar3() {
        return var3;
    }

    public void setVar3(String var3) {
        this.var3 = var3;
    }

    public Question(String question, String answer, String var1, String var2, String var3) {
        this.question = question;
        this.answer = answer;
        this.var1 = var1;
        this.var2 = var2;
        this.var3 = var3;
    }

    @UseFileManager
    public Question(String[] args) throws FileManagerException {
        if(args==null || args.length != 5){
            throw new FileManagerException("Invalid arguments.");
        }
        this.question = args[0];
        this.answer = args[1];
        this.var1 = args[2];
        this.var2 = args[3];
        this.var3 = args[4];
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Question)) return false;
        Question question1 = (Question) o;
        return question.equals(question1.question) && answer.equals(question1.answer) && var1.equals(question1.var1) && var2.equals(question1.var2) && var3.equals(question1.var3);
    }

    @Override
    public int hashCode() {
        return Objects.hash(question, answer, var1, var2, var3);
    }

    public static String[] getVariants(Question question){
        String[] array =  new String[]{question.getAnswer(), question.getVar1(), question.getVar2(), question.getVar3()};
        Collections.shuffle(Arrays.asList(array));
        return array;
    }

    public static ArrayList<Question> readCSV(String file) {

        try {
            Class questionClass = Question.class;
            Field[] fields = questionClass.getDeclaredFields();
            Annotation[] annotations = questionClass.getAnnotations();
            for (int i = 0; i < annotations.length; i++) {
                if (!(annotations[i] instanceof Developer)) {
                    throw new FileManagerException("Not found constructor.");
                }
            }
            ArrayList<Question> arrayList = new ArrayList<>();
            try (Scanner scanner = new Scanner(new File(file))) {
                int count = 0;
                while (scanner.hasNextLine()) {
                    String[] strings = scanner.nextLine().split(";");
                    if (strings.length != fields.length) {
                        throw new FileManagerException("Invalid file format.");
                    }
                    arrayList.add(new Question(strings));
                }
            }
            return arrayList;

        } catch (FileNotFoundException | FileManagerException e) {
            e.printStackTrace();
        }
        return null;
    }

}
