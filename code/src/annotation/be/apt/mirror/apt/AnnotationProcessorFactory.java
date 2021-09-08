package annotation.be.apt.mirror.apt;
/*
Фабрика для создания процессоров аннотаций. Каждая фабрика отвечает за создание процессоров для одного или нескольких типов аннотаций. Говорят, что завод поддерживает эти типы.
Каждая реализация AnnotationProcessorFactory должна предоставлять открытый конструктор без аргументов, который будет использоваться инструментами для создания экземпляра фабрики.
* */

// https://docs.oracle.com/javase/7/docs/jdk/api/apt/mirror/com/sun/mirror/apt/AnnotationProcessorFactory.html
import annotation.be.apt.mirror.declaration.AnnotationTypeDeclaration;

import java.util.Collection;
import java.util.Set;

@LevelH(0)
public interface AnnotationProcessorFactory {
    Collection<String> supportedOptions();
    Collection<String> supportedAnnotationTypes();
    AnnotationProcessor getProcessorFor(Set<AnnotationTypeDeclaration> atds,
                                        AnnotationProcessorEnvironment env);
}
