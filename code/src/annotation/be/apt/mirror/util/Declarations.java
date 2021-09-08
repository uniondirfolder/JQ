package annotation.be.apt.mirror.util;

import annotation.be.apt.mirror.apt.LevelH;
import annotation.be.apt.mirror.declaration.MemberDeclaration;
import annotation.be.apt.mirror.declaration.MethodDeclaration;

// https://docs.oracle.com/javase/7/docs/jdk/api/apt/mirror/com/sun/mirror/util/Declarations.html
@LevelH(0)
public interface Declarations {
    boolean hides(MemberDeclaration sub,
                  MemberDeclaration sup);
    boolean overrides(MethodDeclaration sub,
                      MethodDeclaration sup);
}
