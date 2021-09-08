package annotation.be.apt.mirror.type;

import annotation.be.apt.mirror.apt.LevelH;
import annotation.be.apt.mirror.declaration.ClassDeclaration;

// https://docs.oracle.com/javase/7/docs/jdk/api/apt/mirror/com/sun/mirror/type/ClassType.html
@LevelH(4)
public interface ClassType extends DeclaredType{
    ClassDeclaration getDeclaration();
    ClassType getSuperclass();
}
