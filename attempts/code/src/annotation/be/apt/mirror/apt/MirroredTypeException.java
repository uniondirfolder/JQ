package annotation.be.apt.mirror.apt;

import annotation.be.apt.mirror.type.TypeMirror;
//https://docs.oracle.com/javase/7/docs/jdk/api/apt/mirror/com/sun/mirror/type/MirroredTypeException.html

@LevelH(0)
public class MirroredTypeException extends RuntimeException{
    public MirroredTypeException(TypeMirror type){
        // ToDo

    }
    public TypeMirror getTypeMirror(){
        // ToDo
        return null;
    }
    public String getQualifiedName(){
        // ToDo
        return null;
    }
}
