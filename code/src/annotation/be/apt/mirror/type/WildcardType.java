package annotation.be.apt.mirror.type;
// https://docs.oracle.com/javase/7/docs/jdk/api/apt/mirror/com/sun/mirror/type/WildcardType.html

import annotation.be.apt.mirror.apt.LevelH;

import java.util.Collection;

@LevelH(1)
public interface WildcardType extends TypeMirror{
    Collection<ReferenceType> getUpperBounds();
    Collection<ReferenceType> getLowerBounds();
}
