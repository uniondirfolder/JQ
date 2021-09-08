package annotation.be.apt;


/*Процессор аннотаций, используемый для изучения и обработки аннотаций элементов программы. Обработчик аннотаций может, например, создавать новые исходные файлы и XML-документы для использования в сочетании с исходным кодом.
Обработчик аннотаций создается фабрикой(AnnotationProcessorFactory), которая предоставляет ему среду, инкапсулирует необходимое состояние. Сообщения о предупреждениях и ошибках, возникших во время обработки, должны направляться в Messager, и новые файлы могут быть созданы с помощью Filer.
Каждый обработчик аннотаций создается для обработки аннотаций определенного типа аннотаций или набора типов аннотаций. Он может использовать свою среду для поиска программных элементов с аннотациями этих типов. Он может свободно исследовать любые другие программные элементы в ходе своей обработки.*/

import annotation.be.apt.mirror.apt.AnnotationProcessor;
import annotation.be.apt.mirror.apt.AnnotationProcessorEnvironment;
import annotation.be.apt.mirror.declaration.MethodDeclaration;
import annotation.be.apt.mirror.declaration.Modifier;
import annotation.be.apt.mirror.declaration.ParameterDeclaration;
import annotation.be.apt.mirror.declaration.TypeDeclaration;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

class InterfaceExtractorProcessor implements AnnotationProcessor {
    private final AnnotationProcessorEnvironment env;
    private ArrayList<MethodDeclaration> interfaceMethods = new ArrayList<>();

    public InterfaceExtractorProcessor(AnnotationProcessorEnvironment env) {
        this.env = env;
    }

    @Override
    public void process() {
        for (TypeDeclaration typeDec1 : env.getSpecifiedTypeDeclarations()) {
            ExtractInterface annot = typeDec1.getAnnotation(ExtractInterface.class);
            if (annot == null) break;
            for (MethodDeclaration m : typeDec1.getMethods()) {
                if (m.getModifiers().contains(Modifier.PUBLIC) &&
                        !(m.getModifiers().contains(Modifier.STATIC))) {
                    interfaceMethods.add(m);
                }
            }
            if (interfaceMethods.size() > 0) {
                try {
                    PrintWriter writer = env.getFiler().createSourceFile(annot.value());
                    writer.println("package " + typeDec1.getPackage().getQualifiedName() + ";");
                    writer.println("public interface " + annot.value() + " {");
                    for (MethodDeclaration m : interfaceMethods) {
                        writer.print(" public ");
                        writer.print(m.getReturnType() + " ");
                        writer.print(m.getSimpleName() + " (");
                        int i = 0;
                        for (ParameterDeclaration parm : m.getParameters()) {
                            writer.print((parm.getType() + " " + parm.getSimpleName()));
                            if (++i < m.getParameters().size()) {
                                writer.print(", ");
                            }
                        }
                        writer.println("}");
                        writer.close();
                    }
                } catch (IOException ioe) {
                    throw new RuntimeException(ioe);
                }
            }
        }
    }
}
