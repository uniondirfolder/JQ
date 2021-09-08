package annotation.be.apt.mirror.declaration;

import annotation.be.apt.mirror.apt.LevelH;

import java.util.Collection;

// https://docs.oracle.com/javase/7/docs/jdk/api/apt/mirror/com/sun/mirror/declaration/AnnotationTypeDeclaration.html

@LevelH(5)
public interface AnnotationTypeDeclaration extends InterfaceDeclaration{
    Collection<AnnotationTypeElementDeclaration> getMethods();
}
