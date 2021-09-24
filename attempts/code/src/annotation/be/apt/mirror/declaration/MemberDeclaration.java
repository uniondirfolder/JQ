package annotation.be.apt.mirror.declaration;

// https://docs.oracle.com/javase/7/docs/jdk/api/apt/mirror/com/sun/mirror/declaration/MemberDeclaration.html

import annotation.be.apt.mirror.apt.LevelH;

@LevelH(1)
public interface MemberDeclaration extends Declaration {
    TypeDeclaration getDeclaringType();
}
