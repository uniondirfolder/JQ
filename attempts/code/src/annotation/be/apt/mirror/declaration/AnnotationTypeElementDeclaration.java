package annotation.be.apt.mirror.declaration;

// https://docs.oracle.com/javase/7/docs/jdk/api/apt/mirror/com/sun/mirror/declaration/AnnotationTypeElementDeclaration.html

import annotation.be.apt.mirror.apt.LevelH;

@LevelH(4)
public interface AnnotationTypeElementDeclaration extends MethodDeclaration{
    AnnotationValue getDefaultValue();
    AnnotationTypeDeclaration getDeclaringType();
}
