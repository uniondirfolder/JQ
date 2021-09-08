package annotation.be.apt.mirror.apt;
// https://docs.oracle.com/javase/7/docs/jdk/api/apt/mirror/com/sun/mirror/apt/Messager.html
import annotation.be.apt.mirror.util.SourcePosition;

@LevelH(0)
public interface Messager {
    void printError(String msg);
    void printError(SourcePosition pos,
                    String msg);
    void printWarning(String msg);
    void printWarning(SourcePosition pos,
                      String msg);
    void printNotice(String msg);
    void printNotice(SourcePosition pos,
                     String msg);
}
