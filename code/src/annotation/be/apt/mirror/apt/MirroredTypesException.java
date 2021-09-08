package annotation.be.apt.mirror.apt;

import annotation.be.apt.mirror.type.TypeMirror;

import java.io.Serializable;
import java.util.Collection;
@LevelH(0)
public class MirroredTypesException extends RuntimeException implements Serializable {
    // https://docs.oracle.com/javase/7/docs/jdk/api/apt/mirror/com/sun/mirror/type/MirroredTypesException.html

    public MirroredTypesException(Collection<TypeMirror> types) {
    }
    public Collection<TypeMirror> getTypeMirrors(){
        // ToDo
        return null;
    }
    public Collection<String> getQualifiedNames(){
        // ToDo
        return null;
    }
}
