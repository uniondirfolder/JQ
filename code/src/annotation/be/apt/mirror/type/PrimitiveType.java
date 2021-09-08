package annotation.be.apt.mirror.type;

import java.io.Serializable;

// https://docs.oracle.com/javase/7/docs/jdk/api/apt/mirror/com/sun/mirror/type/PrimitiveType.html
public interface PrimitiveType extends TypeMirror {
    Kind getKind();

    // https://docs.oracle.com/javase/7/docs/jdk/api/apt/mirror/com/sun/mirror/type/PrimitiveType.Kind.html
    enum Kind implements Serializable, Comparable<PrimitiveType.Kind> {
        BOOLEAN,
        BYTE,
        SHORT,
        INT,
        LONG,
        CHAR,
        FLOAT,
        DOUBLE
    }
}
