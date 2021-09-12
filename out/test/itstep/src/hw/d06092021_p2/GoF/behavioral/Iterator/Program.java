package hw.d06092021_p2.GoF.behavioral.Iterator;

public class Program {

    public static void main(String[] args) {
        String[] skills = {"Java", "C#", "MySQL"};
        JavaDeveloper javaDeveloper = new JavaDeveloper("Hacky", skills);

        Iterator iterator = javaDeveloper.getIterator();
        System.out.println("Developer" + javaDeveloper.getName());
        System.out.print("Skills: ");

        while(iterator.hasNext()) {
            System.out.print(iterator.next().toString() + ", ");
        }
    }
}
