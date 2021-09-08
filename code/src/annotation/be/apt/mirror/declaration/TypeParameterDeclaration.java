package annotation.be.apt.mirror.declaration;

import annotation.be.apt.mirror.type.ReferenceType;
// https://docs.oracle.com/javase/7/docs/jdk/api/apt/mirror/com/sun/mirror/declaration/TypeParameterDeclaration.html
import java.util.Collection;

public interface TypeParameterDeclaration extends Declaration{
    Collection<ReferenceType> getBounds();
    Declaration getOwner();
}
