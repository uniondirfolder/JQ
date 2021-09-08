package annotation.be.apt.mirror.util;
// https://docs.oracle.com/javase/7/docs/jdk/api/apt/mirror/com/sun/mirror/util/DeclarationFilter.html

import annotation.be.apt.mirror.declaration.Declaration;

import java.lang.reflect.Modifier;
import java.util.Collection;

public class DeclarationFilter {
    public static final DeclarationFilter FILTER_PUBLIC = new DeclarationFilter();
    public static final DeclarationFilter FILTER_PROTECTED = new DeclarationFilter();
    public static final DeclarationFilter FILTER_PUBLIC_OR_PROTECTED = new DeclarationFilter();
    public static final DeclarationFilter FILTER_PACKAGE = new DeclarationFilter();
    public static final DeclarationFilter FILTER_PRIVATE = new DeclarationFilter();

    public DeclarationFilter() {
    }

    public static DeclarationFilter getFilter(Collection<Modifier> mods) {
        // ToDo must implement
        return null;
    }

    public static DeclarationFilter getFilter(Class<? extends Declaration> kind) {
        // ToDo must implement
        return null;
    }

    public DeclarationFilter and(DeclarationFilter f) {
        // ToDo must implement
        return null;
    }

    public DeclarationFilter or(DeclarationFilter f) {
        // ToDo must implement
        return null;
    }

    public DeclarationFilter not() {
        // ToDo must implement
        return null;
    }

    public boolean matches(Declaration decl) {
        // ToDo must implement
        return true;
    }

    public <D extends Declaration> Collection<D> filter(Collection<D> decls) {
        // ToDo must implement
        return null;
    }

    public <D extends Declaration> Collection<D> filter(Collection<? extends Declaration> decls, Class<D> resType) {
        // ToDo must implement
        return null;
    }
}
