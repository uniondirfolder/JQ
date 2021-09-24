package annotation.be.apt.mirror.util;

import annotation.be.apt.mirror.apt.LevelH;
import annotation.be.apt.mirror.declaration.TypeDeclaration;
import annotation.be.apt.mirror.declaration.TypeParameterDeclaration;
import annotation.be.apt.mirror.type.*;

import java.util.Collection;

@LevelH(0)
public interface Types {
    boolean isSubtype(TypeMirror t1, TypeMirror t2);

    boolean isAssignable(TypeMirror t1, TypeMirror t2);

    TypeMirror getErasure(TypeMirror t);

    PrimitiveType getPrimitiveType(PrimitiveType.Kind kind);

    VoidType getVoidType();

    ArrayType getArrayType(TypeMirror componentType);

    TypeVariable getTypeVariable(TypeParameterDeclaration tparam);

    WildcardType getWildcardType(Collection<ReferenceType> upperBounds,
                                 Collection<ReferenceType> lowerBounds);

    DeclaredType getDeclaredType(TypeDeclaration decl,
                                 TypeMirror... typeArgs);

    DeclaredType getDeclaredType(DeclaredType containing,
                                 TypeDeclaration decl,
                                 TypeMirror... typeArgs);
}
