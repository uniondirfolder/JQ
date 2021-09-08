package annotation.be.apt.mirror.declaration;

import annotation.be.apt.mirror.apt.LevelH;

import java.util.Collection;

// https://docs.oracle.com/javase/7/docs/jdk/api/apt/mirror/com/sun/mirror/declaration/PackageDeclaration.html

@LevelH(1)
public interface PackageDeclaration extends Declaration {
    String getQualifiedName();
    Collection<ClassDeclaration> getClasses();
    Collection<EnumDeclaration> getEnums();
    Collection<InterfaceDeclaration> getInterfaces();
    Collection<AnnotationTypeDeclaration> getAnnotationTypes();
}
