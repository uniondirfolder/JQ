package hw.d06092021_p2.GoF.behavioral.Interpreter;

public class Program {

    public static void main(String[] args) {
        Expression isJava = getJavaExpression();
        Expression isJavaEE = getJavaEEExpression();
        
        System.out.println("Does developer knows Java Core: " + isJava.interpret("Java"));
        System.out.println("Does developer knows Java EE: " + isJavaEE.interpret("Java"));
    }
    
    public static Expression getJavaExpression() {
        Expression java = new TerminalExpression("Java");
        Expression javaCore = new TerminalExpression("Java Core");
        return new OrExpression(java, javaCore);
    }
    
    public static Expression getJavaEEExpression() {
        Expression java = new TerminalExpression("Java");
        Expression spring = new TerminalExpression("Spring");
        return new AndExpression(java, spring);
    }
}
