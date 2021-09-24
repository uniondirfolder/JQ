package annotation.be.apt.mirror.util;

import annotation.be.apt.mirror.apt.LevelH;
import annotation.be.apt.mirror.declaration.*;

@LevelH(0)
public interface DeclarationVisitor {
    void visitDeclaration(Declaration d);
    void visitPackageDeclaration(PackageDeclaration d);
    void visitMemberDeclaration(MemberDeclaration d);
    void visitTypeDeclaration(TypeDeclaration d);
    void visitClassDeclaration(ClassDeclaration d);
    void visitEnumDeclaration(EnumDeclaration d);
    void visitInterfaceDeclaration(InterfaceDeclaration d);
    void visitAnnotationTypeDeclaration(AnnotationTypeDeclaration d);
    void visitFieldDeclaration(FieldDeclaration d);
    void visitEnumConstantDeclaration(EnumConstantDeclaration d);
    void visitExecutableDeclaration(ExecutableDeclaration d);
    void visitConstructorDeclaration(ConstructorDeclaration d);
    void visitMethodDeclaration(MethodDeclaration d);
    void visitAnnotationTypeElementDeclaration(AnnotationTypeElementDeclaration d);
    void visitParameterDeclaration(ParameterDeclaration d);
    void visitTypeParameterDeclaration(TypeParameterDeclaration d);
}
