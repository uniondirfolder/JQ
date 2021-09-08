package annotation.be.apt.mirror.declaration;

import java.util.Collection;

// https://docs.oracle.com/javase/7/docs/jdk/api/apt/mirror/com/sun/mirror/declaration/EnumDeclaration.html
public interface EnumDeclaration extends ClassDeclaration{
    Collection<EnumConstantDeclaration> getEnumConstants();
}
