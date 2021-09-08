package annotation.be.apt.mirror.declaration;

// https://docs.oracle.com/javase/7/docs/jdk/api/apt/mirror/com/sun/mirror/declaration/AnnotationValue.html
import annotation.be.apt.mirror.apt.LevelH;
import annotation.be.apt.mirror.util.SourcePosition;

@LevelH(0)
public interface AnnotationValue {
    Object getValue();
    SourcePosition getPosition();
    String toString();
}
