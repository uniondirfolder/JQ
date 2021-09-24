package annotation.be.apt.mirror.declaration;

// https://docs.oracle.com/javase/7/docs/jdk/api/apt/mirror/com/sun/mirror/declaration/AnnotationMirror.html

import annotation.be.apt.mirror.apt.LevelH;
import annotation.be.apt.mirror.type.AnnotationType;
import annotation.be.apt.mirror.util.SourcePosition;

import java.util.Map;

@LevelH(0)
public interface AnnotationMirror {
    AnnotationType getAnnotationType();
    SourcePosition getPosition();
    Map<AnnotationTypeElementDeclaration,AnnotationValue> getElementValues();
}
