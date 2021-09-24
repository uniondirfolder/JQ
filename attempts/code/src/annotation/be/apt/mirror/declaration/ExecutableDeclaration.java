package annotation.be.apt.mirror.declaration;

import annotation.be.apt.mirror.apt.LevelH;
import annotation.be.apt.mirror.type.ReferenceType;

import java.util.Collection;

// https://docs.oracle.com/javase/7/docs/jdk/api/apt/mirror/com/sun/mirror/declaration/ExecutableDeclaration.html
@LevelH(2)
public interface ExecutableDeclaration extends MemberDeclaration{
    boolean isVarArgs();
    Collection<TypeParameterDeclaration> getFormalTypeParameters();
    Collection<ParameterDeclaration> getParameters();
    Collection<ReferenceType> getThrownTypes();
}
