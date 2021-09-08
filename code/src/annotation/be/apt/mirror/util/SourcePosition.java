package annotation.be.apt.mirror.util;

import java.io.File;

public interface SourcePosition {
    // https://docs.oracle.com/javase/7/docs/api/java/io/File.html?is-external=true
    File file();
    int line();
    int column();
}
