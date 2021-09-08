package annotation.be.apt;

import annotation.be.apt.mirror.apt.AnnotationProcessor;
import annotation.be.apt.mirror.apt.AnnotationProcessorEnvironment;
import annotation.be.apt.mirror.apt.AnnotationProcessorFactory;
import annotation.be.apt.mirror.declaration.AnnotationTypeDeclaration;

import java.util.Collection;
import java.util.Collections;
import java.util.Set;

public class InterfaceProcessorFactory implements AnnotationProcessorFactory {
    @Override
    public Collection<String> supportedOptions() {
        return Collections.emptySet();
    }

    @Override
    public Collection<String> supportedAnnotationTypes() {
        return Collections.singleton("annotations.ExtractInterface"); // current package
    }

    @Override
    public AnnotationProcessor getProcessorFor(Set<AnnotationTypeDeclaration> atds, AnnotationProcessorEnvironment env) {
        return new InterfaceExtractorProcessor(env);
    }
}
