package annotation.be.apt.mirror.declaration;
// https://docs.oracle.com/javase/7/docs/jdk/api/apt/mirror/com/sun/mirror/declaration/MethodDeclaration.html
import annotation.be.apt.mirror.apt.LevelH;
import annotation.be.apt.mirror.type.TypeMirror;

@LevelH(3)
public interface MethodDeclaration extends ExecutableDeclaration{
    // Returns the formal return type of this method. Returns VoidType if this method does not return a value.
    TypeMirror getReturnType();
}
