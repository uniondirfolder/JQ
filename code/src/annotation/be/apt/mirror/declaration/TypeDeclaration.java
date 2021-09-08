package annotation.be.apt.mirror.declaration;

// https://docs.oracle.com/javase/7/docs/jdk/api/apt/mirror/com/sun/mirror/declaration/TypeDeclaration.html
import annotation.be.apt.mirror.apt.LevelH;
import annotation.be.apt.mirror.type.InterfaceType;

import java.util.Collection;

@LevelH(2)
public interface TypeDeclaration extends MemberDeclaration{
    PackageDeclaration getPackage();
    String getQualifiedName();
    Collection<TypeParameterDeclaration> getFormalTypeParameters();
    Collection<InterfaceType> getSuperinterfaces();
    Collection<FieldDeclaration> getFields();
    Collection<? extends MethodDeclaration> getMethods();
    Collection<TypeDeclaration> getNestedTypes();
}
