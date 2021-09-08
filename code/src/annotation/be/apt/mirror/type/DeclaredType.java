package annotation.be.apt.mirror.type;

import annotation.be.apt.mirror.apt.LevelH;
import annotation.be.apt.mirror.declaration.TypeDeclaration;

import java.util.Collection;

// https://docs.oracle.com/javase/7/docs/jdk/api/apt/mirror/com/sun/mirror/type/DeclaredType.html
@LevelH(3)
public interface DeclaredType extends ReferenceType{
    TypeDeclaration getDeclaration();
    DeclaredType getContainingType();
    Collection<TypeMirror> getActualTypeArguments();
    Collection<InterfaceType> getSuperinterfaces();
}
