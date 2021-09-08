package annotation.be.apt.mirror.declaration;

// https://docs.oracle.com/javase/7/docs/jdk/api/apt/mirror/com/sun/mirror/declaration/ClassDeclaration.html

import annotation.be.apt.mirror.type.ClassType;

import java.util.Collection;

public interface ClassDeclaration extends TypeDeclaration {
    ClassType getSuperclass();
    Collection<ConstructorDeclaration> getConstructors();
    Collection<MethodDeclaration> getMethods();
}
