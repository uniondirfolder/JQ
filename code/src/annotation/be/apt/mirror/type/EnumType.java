package annotation.be.apt.mirror.type;

import annotation.be.apt.mirror.apt.LevelH;
import annotation.be.apt.mirror.declaration.EnumDeclaration;
// https://docs.oracle.com/javase/7/docs/jdk/api/apt/mirror/com/sun/mirror/type/EnumType.html
@LevelH(5)
public interface EnumType extends ClassType{
    EnumDeclaration getDeclaration();
}
