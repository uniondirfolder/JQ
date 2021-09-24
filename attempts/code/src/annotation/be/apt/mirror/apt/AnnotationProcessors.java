package annotation.be.apt.mirror.apt;

import java.util.Collection;
// https://docs.oracle.com/javase/7/docs/jdk/api/apt/mirror/com/sun/mirror/apt/AnnotationProcessors.html

@LevelH(0)
public class AnnotationProcessors {
    public AnnotationProcessors() {
    }
    public static final AnnotationProcessor NO_OP = null; // ???

    public static AnnotationProcessor getCompositeAnnotationProcessor(AnnotationProcessor... aps){
        // ToDo
        return null;
    }
    public static AnnotationProcessor getCompositeAnnotationProcessor(Collection<AnnotationProcessor> aps){
        // ToDo
        return null;
    }
}
