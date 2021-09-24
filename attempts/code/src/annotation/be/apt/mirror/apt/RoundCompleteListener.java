package annotation.be.apt.mirror.apt;

// https://docs.oracle.com/javase/7/docs/jdk/api/apt/mirror/com/sun/mirror/apt/AnnotationProcessorListener.html
@LevelH(2)
public interface RoundCompleteListener extends AnnotationProcessorListener{
    void roundComplete(RoundCompleteEvent event);
}
