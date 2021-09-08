package annotation.be.apt.mirror.type;
// https://docs.oracle.com/javase/7/docs/jdk/api/apt/mirror/com/sun/mirror/type/TypeMirror.html

import annotation.be.apt.mirror.apt.LevelH;
import annotation.be.apt.mirror.util.TypeVisitor;

@LevelH(0)
public interface TypeMirror {
    void accept(TypeVisitor v);
}
