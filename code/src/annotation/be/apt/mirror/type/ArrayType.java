package annotation.be.apt.mirror.type;
// https://docs.oracle.com/javase/7/docs/jdk/api/apt/mirror/com/sun/mirror/type/ArrayType.html

import annotation.be.apt.mirror.apt.LevelH;

@LevelH(2)
public interface ArrayType extends ReferenceType{
    TypeMirror getComponentType();
}
