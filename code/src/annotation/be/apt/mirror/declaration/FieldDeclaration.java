package annotation.be.apt.mirror.declaration;
// https://docs.oracle.com/javase/7/docs/jdk/api/apt/mirror/com/sun/mirror/declaration/FieldDeclaration.html
import annotation.be.apt.mirror.type.TypeMirror;

public interface FieldDeclaration extends MemberDeclaration{
    TypeMirror getType();
    Object getConstantValue();
    String getConstantExpression();
}
