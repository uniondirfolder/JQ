package annotation.be.apt.mirror.declaration;
// https://docs.oracle.com/javase/7/docs/jdk/api/apt/mirror/com/sun/mirror/declaration/Declaration.html


import annotation.be.apt.mirror.apt.LevelH;
import annotation.be.apt.mirror.util.DeclarationVisitor;
import annotation.be.apt.mirror.util.SourcePosition;

import java.lang.annotation.Annotation;

import java.util.Collection;

@LevelH(0)
public interface Declaration {
    boolean equals(Object obj);
    String getDocComment(); // Returns the text of the documentation ("javadoc") comment of this declaration.
    Collection<AnnotationMirror> getAnnotationMirrors(); // Returns the annotations that are directly present on this declaration.
    <A extends Annotation> A getAnnotation(Class<A> annotationType);
    Collection<Modifier> getModifiers();
    String getSimpleName();
    SourcePosition getPosition();
    void accept(DeclarationVisitor v);
}
