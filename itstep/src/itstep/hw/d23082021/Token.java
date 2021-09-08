package itstep.hw.d23082021;
@Developer
public enum Token {
    DIGIT("0...9"),
    PLUS("+"),
    MINUS("-"),
    DIVIDE("/"),
    LEFT_BRACKETS("("),
    MULTIPLICATION("*"),
    RIGHT_BRACKETS(")"),
    WHITESPACE(" ");

    final public String value;

    Token(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return " {" +value +'}' ;
    }
}
