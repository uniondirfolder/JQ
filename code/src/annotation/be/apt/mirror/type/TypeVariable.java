package annotation.be.apt.mirror.type;
// https://docs.oracle.com/javase/7/docs/jdk/api/apt/mirror/com/sun/mirror/type/TypeVariable.html

import annotation.be.apt.mirror.apt.LevelH;
import annotation.be.apt.mirror.declaration.TypeParameterDeclaration;

@LevelH(2)
public interface TypeVariable extends ReferenceType{
    TypeParameterDeclaration getDeclaration();
}
