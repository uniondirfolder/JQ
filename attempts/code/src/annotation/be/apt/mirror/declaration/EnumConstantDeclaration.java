package annotation.be.apt.mirror.declaration;

// https://docs.oracle.com/javase/7/docs/jdk/api/apt/mirror/com/sun/mirror/declaration/EnumConstantDeclaration.html
public interface EnumConstantDeclaration extends FieldDeclaration{
    EnumDeclaration getDeclaringType();
}
