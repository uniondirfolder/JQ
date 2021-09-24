package annotation.be.apt.mirror.apt;

import annotation.be.apt.mirror.declaration.AnnotationTypeDeclaration;
import annotation.be.apt.mirror.declaration.Declaration;
import annotation.be.apt.mirror.declaration.PackageDeclaration;
import annotation.be.apt.mirror.declaration.TypeDeclaration;
import annotation.be.apt.mirror.util.Declarations;
import annotation.be.apt.mirror.util.Types;

import java.util.Collection;
import java.util.Map;

// https://docs.oracle.com/javase/7/docs/jdk/api/apt/mirror/com/sun/mirror/apt/AnnotationProcessorEnvironment.html

@LevelH(0)
public interface AnnotationProcessorEnvironment {
    Map<String,String> getOptions();
    Messager getMessager();
    Filer getFiler();
    Collection<TypeDeclaration> getSpecifiedTypeDeclarations();
    PackageDeclaration getPackage(String name);
    TypeDeclaration getTypeDeclaration(String name);
    Collection<TypeDeclaration> getTypeDeclarations();
    Collection<Declaration> getDeclarationsAnnotatedWith(AnnotationTypeDeclaration a);
    Declarations getDeclarationUtils();
    Types getTypeUtils();
    void addListener(AnnotationProcessorListener listener);
    void removeListener(AnnotationProcessorListener listener);
}
