package annotation.be.apt.mirror.type;

import annotation.be.apt.mirror.apt.LevelH;
import annotation.be.apt.mirror.declaration.AnnotationTypeDeclaration;

@LevelH(5)
public interface AnnotationType extends InterfaceType{
    AnnotationTypeDeclaration getDeclaration();
}
