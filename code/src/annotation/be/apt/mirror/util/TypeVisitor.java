package annotation.be.apt.mirror.util;

import annotation.be.apt.mirror.apt.LevelH;
import annotation.be.apt.mirror.type.*;


// https://docs.oracle.com/javase/7/docs/jdk/api/apt/mirror/com/sun/mirror/util/TypeVisitor.html

@LevelH(0)
public interface TypeVisitor {
    void visitTypeMirror(TypeMirror t);
    void visitPrimitiveType(PrimitiveType t);
    void visitVoidType(VoidType t);
    void visitReferenceType(ReferenceType t);
    void visitDeclaredType(DeclaredType t);
    void visitClassType(ClassType t);
    void visitEnumType(EnumType t);
    void visitInterfaceType(InterfaceType t);
    void visitAnnotationType(AnnotationType t);
    void visitArrayType(ArrayType t);
    void visitTypeVariable(TypeVariable t);
    void visitWildcardType(WildcardType t);
}
