package annotation.be.apt.mirror.apt;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
// https://docs.oracle.com/javase/7/docs/jdk/api/apt/mirror/com/sun/mirror/apt/Filer.html

@LevelH(0)
public interface Filer {
    enum Location {
        SOURCE_TREE,
        CLASS_TREE
    }

    PrintWriter createSourceFile(String name) throws IOException;

    OutputStream createClassFile(String name) throws IOException;

    PrintWriter createTextFile(Filer.Location loc,
                               String pkg,
                               File relPath,
                               String charsetName)
            throws IOException;

    OutputStream createBinaryFile(Filer.Location loc,
                                  String pkg,
                                  File relPath)
            throws IOException;
}
